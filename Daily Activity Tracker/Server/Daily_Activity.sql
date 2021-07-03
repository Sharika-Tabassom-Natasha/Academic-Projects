SET SERVEROUTPUT ON;

-- show available activity ---------------------
create or replace procedure activity_show(USERTYPE in user_table.user_type%TYPE)
	IS
    ACTIVITYNAME activity.activity_name%TYPE;
    ACTIVITYTYPE activity.activity_type%TYPE;

begin
    DBMS_OUTPUT.PUT_LINE(chr(10));
	DBMS_OUTPUT.PUT_LINE('---------- Available Activity list ----------');
    DBMS_OUTPUT.PUT_LINE('+-------------------------------------------+');
	DBMS_OUTPUT.PUT_LINE('|         Name        |         Type        |');
	DBMS_OUTPUT.PUT_LINE('+-------------------------------------------+');

    for R in (select activity_name, activity_type from activity where user_type = USERTYPE)  loop
        ACTIVITYNAME := R.activity_name;
        ACTIVITYTYPE := R.activity_type;
        DBMS_OUTPUT.PUT_LINE('| '||rpad(ACTIVITYNAME, 20)||'| '||rpad(ACTIVITYTYPE, 20)||'|');
    end loop;
	DBMS_OUTPUT.PUT_LINE('+-------------------------------------------+');
	DBMS_OUTPUT.PUT_LINE(chr(10));
		
end activity_show;
/

-- show one user's current date activity ------------
create or replace procedure user_activity_show(USERID in user_table.user_ID%TYPE)
	IS
    ACTIVITYHOUR user_activity.hour%TYPE;
    ACTIVITYNAME activity.activity_name%TYPE;
    ACTIVITYNOTE user_activity.short_note%TYPE;
    CURRENTT_DATE DATE;
    PRED number := 0;

begin
    CURRENTT_DATE := SYSDATE;
	DBMS_OUTPUT.PUT_LINE('------------- Your todays Activity ('||CURRENTT_DATE||') -------------');
    DBMS_OUTPUT.PUT_LINE('+----------------------------------------------------------+');
	DBMS_OUTPUT.PUT_LINE('|       Activity      |  Duration  |      Short notes      |');
	DBMS_OUTPUT.PUT_LINE('+----------------------------------------------------------+');

    for R in (SELECT activity.activity_name, user_activity.hour,user_activity.short_note FROM user_activity INNER JOIN activity 
    ON user_activity.activity_ID = activity.activity_ID 
    where user_activity.user_ID = USERID and user_activity.activity_date = trunc(CURRENT_DATE))  loop
        ACTIVITYNAME := R.activity_name;
        ACTIVITYHOUR := R.hour;
        ACTIVITYNOTE := R.short_note;
        DBMS_OUTPUT.PUT_LINE('| '||rpad(ACTIVITYNAME, 20)||'| Hours: '||rpad(to_char(ACTIVITYHOUR), 4)||'| '||rpad(ACTIVITYNOTE, 22)||'|');
    end loop;
	DBMS_OUTPUT.PUT_LINE('+----------------------------------------------------------+');
	DBMS_OUTPUT.PUT_LINE(chr(10));
    PRED := daily_predict(USERID);
    if PRED = 2 then
        DBMS_OUTPUT.PUT_LINE('User type prediction: Very Busy user.');
    elsif PRED = 1 then
        DBMS_OUTPUT.PUT_LINE('User type prediction: Moderately busy user.');
    else
        DBMS_OUTPUT.PUT_LINE('User type prediction: Lazy user.');
    end if;
    DBMS_OUTPUT.PUT_LINE(chr(10));
    DBMS_OUTPUT.PUT_LINE('Recomandation:');
    daily_recomandation(USERID);
    DBMS_OUTPUT.PUT_LINE(chr(10));
		
end user_activity_show;
/

-- insert new activity for that user -----------------
create or replace procedure insert_user_activity(USERID in user_table.user_ID%TYPE, USERTYPE in user_table.user_type%TYPE)
IS
    ACTIVITYNAME activity.activity_name%TYPE := '&p';
    ACTIVITYHOUR user_activity.hour%TYPE := &q;
    ACTIVITYNOTE user_activity.short_note%TYPE := '&r';
    ACTIVITYID activity.activity_ID%TYPE;
    ACTIVITYDATE user_activity.activity_date%TYPE;
    ACTIVITYUSERID user_activity.user_activity_ID%TYPE;
    HOURSUM number;
    Day_Exceed exception;

  begin
    select activity_ID into ACTIVITYID from activity where activity_name = ACTIVITYNAME and user_type = USERTYPE;
    select max(user_activity_ID) into ACTIVITYUSERID from user_activity;
    SELECT sum(user_activity.hour) into HOURSUM FROM user_activity INNER JOIN activity 
    ON user_activity.activity_ID = activity.activity_ID 
    where user_activity.user_ID = USERID and user_activity.activity_date = trunc(CURRENT_DATE);

    HOURSUM := HOURSUM + ACTIVITYHOUR;
    if (HOURSUM) > 24 then 
        raise Day_Exceed;
    else
        insert into user_activity values(ACTIVITYUSERID+1,USERID,ACTIVITYID,ACTIVITYHOUR,trunc(CURRENT_DATE),ACTIVITYNOTE);
    end if;

    exception

	when no_data_found then
      DBMS_OUTPUT.PUT_LINE(chr(10));
      dbms_output.put_line('No such activity available. Check the available activity table.');

    when Day_Exceed then
      DBMS_OUTPUT.PUT_LINE(chr(10));
      DBMS_OUTPUT.PUT_LINE('Not enough time for the activity (Exceeding 24 hours).');

    commit;
end insert_user_activity;
/


-- delete existing activity of today -----------
create or replace procedure delete_user_activity(USERID in user_table.user_ID%TYPE, USERTYPE in user_table.user_type%TYPE)
IS
    ACTIVITYNAME activity.activity_name%TYPE := '&s';

begin
    delete from user_activity where user_ID = USERID and activity_date = trunc(CURRENT_DATE) and 
    activity_ID = (select activity_ID from activity where activity_name = LOWER(ACTIVITYNAME) and user_type = USERTYPE);

end delete_user_activity;
/


-- 1. daily activity page of the user -----------
create or replace procedure manage_user_activity(USERID in user_table.user_ID%TYPE)
	IS
	    UDERTYPE user_table.user_type%TYPE;
        MENU_OPTION number := &t;
BEGIN
	select user_type into UDERTYPE from user_table where user_ID = USERID;

    DBMS_OUTPUT.PUT_LINE('-- 1.Your Daily Activity Page -----------------------------------');
    DBMS_OUTPUT.PUT_LINE(chr(10));

    user_activity_show(USERID);

    DBMS_OUTPUT.PUT_LINE('+-------------------------------------+');
    DBMS_OUTPUT.PUT_LINE('|                Menu                 |');
    DBMS_OUTPUT.PUT_LINE('+-------------------------------------+');
    DBMS_OUTPUT.PUT_LINE('| 1. Insert New Activity              |');
    DBMS_OUTPUT.PUT_LINE('| 2. Delete Existing Activity         |');
    DBMS_OUTPUT.PUT_LINE('+-------------------------------------+');
    DBMS_OUTPUT.PUT_LINE('Select option from above menu (1/2/3): '||MENU_OPTION);

    	IF MENU_OPTION = 1 THEN
            activity_show(UDERTYPE);
			insert_user_activity(USERID,UDERTYPE);
            user_activity_show(USERID);
		ELSIF MENU_OPTION = 2 THEN
			delete_user_activity(USERID,UDERTYPE);
			user_activity_show(USERID);
		ELSE
			DBMS_OUTPUT.PUT_LINE('No available option selected.');
		end if;

    DBMS_OUTPUT.PUT_LINE(chr(10));

	end manage_user_activity;
	/
