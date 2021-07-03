SET SERVEROUTPUT ON;
-- view containing users last 7 days activity

create or replace procedure mange_weekly_chart(USERID in user_table.user_ID%TYPE)
    IS
    STARTDATE user_activity.activity_date%TYPE;
    PERHOUR number;
    PERCENTAGE number;
    TOTALHOUR number := 0;
    PRED number := 0;
    i number :=0;
begin

    select min(activity_date) into STARTDATE from weekly_activity_table where user_ID = USERID;
    DBMS_OUTPUT.PUT_LINE(chr(10));
    DBMS_OUTPUT.PUT_LINE('-- 2. Your Weekly Activity Page ------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE(chr(10));
    DBMS_OUTPUT.PUT_LINE('Date: ('||STARTDATE||') to ('||(STARTDATE+6)||')');
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------------------------------');

    -- per day calculation ----
    LOOP
        DBMS_OUTPUT.PUT(' | ' || rpad(STARTDATE, 10));

        for R in (select activity_type from weekly_activity_table where user_ID = USERID 
        and activity_date = STARTDATE GROUP BY activity_type) loop
            DBMS_OUTPUT.PUT(' | ' || rpad(R.activity_type, 15));
        end loop;
        DBMS_OUTPUT.PUT(' | ' || rpad('others', 15));
        DBMS_OUTPUT.new_line();
        DBMS_OUTPUT.PUT(' | ' ||rpad(TO_CHAR(STARTDATE,'DAY'), 10));

        for R in (select sum(hour) as PERHOUR from weekly_activity_table where user_ID = USERID 
        and activity_date = STARTDATE GROUP BY activity_type) loop
            PERCENTAGE := (100/24)*R.PERHOUR;
            TOTALHOUR := TOTALHOUR+R.PERHOUR;
            DBMS_OUTPUT.PUT(' | ' || rpad(ROUND(PERCENTAGE), 3)||'%           ');
        end loop;

        PERCENTAGE := (100/24)*(24-TOTALHOUR);
        TOTALHOUR := 0;
        DBMS_OUTPUT.PUT(' | ' || rpad(ROUND(PERCENTAGE), 3)||'%           ');
        DBMS_OUTPUT.new_line();
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------------------------------');
        STARTDATE := STARTDATE+1;
        i := i+1;
    EXIT WHEN i = 7;
    END LOOP;

    -- full week caclulation ----
    DBMS_OUTPUT.PUT(' | ' ||rpad('Full', 4));
    for R in (select activity_type from weekly_activity_table where user_ID = USERID GROUP BY activity_type) loop
        DBMS_OUTPUT.PUT(' | ' || rpad(R.activity_type, 13));
    end loop;
    DBMS_OUTPUT.PUT(' | ' || rpad('others', 6));
    DBMS_OUTPUT.new_line();
    DBMS_OUTPUT.PUT(' | ' ||rpad('Week', 4));

    for R in (select sum(hour) as PERHOUR from weekly_activity_table where user_ID = USERID GROUP BY activity_type) loop
        PERCENTAGE := (100/168)*R.PERHOUR;
        TOTALHOUR := TOTALHOUR+R.PERHOUR;
        DBMS_OUTPUT.PUT(' | ' || rpad(ROUND(PERCENTAGE), 3)||'%         ');
    end loop;

    PERCENTAGE := (100/168)*(168-TOTALHOUR);
    DBMS_OUTPUT.PUT(' | ' || rpad(ROUND(PERCENTAGE), 3)||'%   ');
    DBMS_OUTPUT.new_line();
    DBMS_OUTPUT.PUT_LINE(chr(10));

    PRED := weekly_predict(USERID);
    if PRED = 2 then
        DBMS_OUTPUT.PUT_LINE('User type prediction: Very Busy user.');
    elsif PRED = 1 then
        DBMS_OUTPUT.PUT_LINE('User type prediction: Moderately busy user.');
    else
        DBMS_OUTPUT.PUT_LINE('User type prediction: Lazy user.');
    end if;
    DBMS_OUTPUT.PUT_LINE(chr(10));
    DBMS_OUTPUT.PUT_LINE('Recomandation:');
    weekly_recomandation(USERID);
    DBMS_OUTPUT.PUT_LINE(chr(10));
		
end mange_weekly_chart;
/
