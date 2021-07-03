SET SERVEROUTPUT ON;

-- server view containing users last 7 days activity
CREATE OR REPLACE VIEW weekly_activity_table AS
SELECT activity.activity_name, activity.activity_type, user_activity.activity_date, user_activity.hour, user_activity.user_ID
FROM user_activity INNER JOIN activity
ON user_activity.activity_ID = activity.activity_ID
where activity_date > trunc(CURRENT_DATE-7) 
and activity_date <= trunc(CURRENT_DATE);

-- site view containing users last 7 days activity
CREATE OR REPLACE VIEW weekly_activity_table_site AS
SELECT activity.activity_name, activity.activity_type, user_activity.activity_date, user_activity.hour, user_activity.user_ID
FROM user_activity@site_link INNER JOIN activity@site_link
ON user_activity.activity_ID = activity.activity_ID
where activity_date > trunc(CURRENT_DATE-7) 
and activity_date <= trunc(CURRENT_DATE);

-- login function for both server and site
create or replace function user_login(USERNAME in user_table.user_name%TYPE, USERPASS in user_table.user_password%TYPE, USERID out user_table.user_ID%TYPE, USERFROM out number)
  return number
  is
begin
	FOR R IN (SELECT user_ID,user_name,user_password,user_type from user_table
	union SELECT user_ID,user_name,user_password,user_type from user_table@site_link) LOOP
	USERID := R.user_ID;
	IF USERNAME = R.user_name THEN
		IF USERPASS = R.user_password THEN
		if R.user_type = 'Undergraduate' then
			USERFROM := 1;
		else
			USERFROM := 0;
		end if;
		return 1;	
		END IF;
	END IF;
	END LOOP;
	return 0;
end user_login;
/

DECLARE
	USERNAME user_table.user_name%TYPE := '&x';
	USERPASS user_table.user_password%TYPE := '&y';
	USERID user_table.user_ID%TYPE;
	USERFROM number;
	LOGIN number := 0;
	MENU_OPTION number := &z;
	
BEGIN
	LOGIN := user_login(USERNAME,USERPASS,USERID,USERFROM);

    IF LOGIN = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Invalid username of password');
	ELSIF LOGIN = 1 and USERFROM = 0 THEN
		DBMS_OUTPUT.PUT_LINE(chr(10));
		DBMS_OUTPUT.PUT_LINE('----- Welcome to Activity Monitor -----');
		DBMS_OUTPUT.PUT_LINE('+-------------------------------------+');
		DBMS_OUTPUT.PUT_LINE('|                Menu                 |');
		DBMS_OUTPUT.PUT_LINE('+-------------------------------------+');
		DBMS_OUTPUT.PUT_LINE('| 1. Your Daily activity              |');
		DBMS_OUTPUT.PUT_LINE('| 2. Your weekly activity chart       |');
		DBMS_OUTPUT.PUT_LINE('+-------------------------------------+');
		DBMS_OUTPUT.PUT_LINE('Select option from above menu (1/2): '||MENU_OPTION);
		DBMS_OUTPUT.PUT_LINE(chr(10));
		--DBMS_OUTPUT.PUT_LINE('------Select option from the menu------');

		IF MENU_OPTION = 1 THEN
			manage_user_activity(USERID);
		ELSIF MENU_OPTION = 2 THEN
			mange_weekly_chart(USERID,USERFROM);
		ELSE
			DBMS_OUTPUT.PUT_LINE('No available option selected.');
		end if;

	ELSIF LOGIN = 1 and USERFROM = 1 THEN 
		mange_weekly_chart(USERID,USERFROM);
	END IF;
END;

/
