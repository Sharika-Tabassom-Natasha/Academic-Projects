SET SERVEROUTPUT ON;

-- view containing users last 7 days activity
CREATE OR REPLACE VIEW weekly_activity_table AS
SELECT activity.activity_name, activity.activity_type, user_activity.activity_date, user_activity.hour, user_activity.user_ID
FROM user_activity INNER JOIN activity
ON user_activity.activity_ID = activity.activity_ID
where activity_date > trunc(CURRENT_DATE-7) 
and activity_date <= trunc(CURRENT_DATE);

create or replace function user_login(USERNAME in user_table.user_name%TYPE, USERPASS in user_table.user_password%TYPE, USERID out user_table.user_ID%TYPE)
  return number
  is
  NAMEE user_table.user_name%TYPE;
  PASSWORD user_table.user_password%TYPE;

begin
	FOR R IN (SELECT user_ID,user_name,user_password from user_table) LOOP
	  USERID := R.user_ID;
	  NAMEE := R.user_name;
	  PASSWORD := R.user_password;
	  IF USERNAME = NAMEE THEN
	   IF USERPASS = PASSWORD THEN
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
	LOGIN number := 0;
	MENU_OPTION number := &z;
	

BEGIN
	LOGIN := user_login(USERNAME,USERPASS,USERID);
    IF LOGIN = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Invalid username of password');
	ELSIF LOGIN = 1 THEN
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
			mange_weekly_chart(USERID);
		ELSE
			DBMS_OUTPUT.PUT_LINE('No available option selected.');
		end if;
	 
	END IF;
END;

/
