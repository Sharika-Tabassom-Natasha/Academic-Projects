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

create or replace function daily_predict(USERID IN user_table.user_ID%TYPE)
  return number
  is
  PERCENTAGE number := 0;
  PERHOUR number;

begin
	FOR R IN (SELECT activity.activity_type, sum(user_activity.hour) as PERHOUR FROM user_activity 
    INNER JOIN activity ON user_activity.activity_ID = activity.activity_ID where user_activity.user_ID = USERID 
    and user_activity.activity_date = trunc(CURRENT_DATE) group by activity.activity_type)  LOOP
    if (R.activity_type ='work' or R.activity_type ='skill develop') then
      PERCENTAGE := PERCENTAGE + R.PERHOUR;
    end if;
	END LOOP;

    if PERCENTAGE>12 then
      return 2;
    elsif PERCENTAGE>10 then
      return 1;
    else
      return 0;
    end if;

end daily_predict;
/

create or replace procedure daily_recomandation(USERID IN user_table.user_ID%TYPE)
  is
  PERCENTAGE number := 0;
  TOTAL number := 0;
  PERHOUR number;

begin
	FOR R IN (SELECT activity.activity_type, sum(user_activity.hour) as PERHOUR FROM user_activity 
    INNER JOIN activity ON user_activity.activity_ID = activity.activity_ID where user_activity.user_ID = USERID 
    and user_activity.activity_date = trunc(CURRENT_DATE) group by activity.activity_type)  LOOP
    TOTAL := TOTAL + R.PERHOUR;
    if (R.activity_type ='work' or R.activity_type ='skill develop') then
      PERCENTAGE := PERCENTAGE + R.PERHOUR;
    end if;
	END LOOP;

    if PERCENTAGE>12 then
      DBMS_OUTPUT.PUT_LINE('Over working.');
    end if;
    if (24-TOTAL)<7 then
      DBMS_OUTPUT.PUT_LINE('Not enough sleep.');
    end if;

    if PERCENTAGE<6 OR (24-TOTAL)>16 then
      DBMS_OUTPUT.PUT_LINE('Free through out the day.');
      DBMS_OUTPUT.PUT_LINE('Can work on skill development.');
      DBMS_OUTPUT.PUT_LINE('Can engaged with more work.');
    end if;

end daily_recomandation;
/


create or replace function weekly_predict(USERID IN user_table.user_ID%TYPE, USERFROM IN number)
  return number
  is
  PERCENTAGE number := 0;
  PERHOUR number;

begin

if USERFROM = 1 then
  	FOR R IN (select activity_type, sum(hour) as PERHOUR from weekly_activity_table_site where user_ID = USERID GROUP BY activity_type)  LOOP
    if (R.activity_type ='education') then
      PERCENTAGE := PERCENTAGE + R.PERHOUR;
    end if;
	END LOOP;

else
	FOR R IN (select activity_type, sum(hour) as PERHOUR from weekly_activity_table where user_ID = USERID GROUP BY activity_type)  LOOP
    if (R.activity_type ='work' or R.activity_type ='skill develop') then
      PERCENTAGE := PERCENTAGE + R.PERHOUR;
    end if;
	END LOOP;
end if;

    if PERCENTAGE>84 then
      return 2;
    elsif PERCENTAGE>70 then
      return 1;
    else
      return 0;
    end if;

end weekly_predict;
/

create or replace procedure weekly_recomandation(USERID IN user_table.user_ID%TYPE, USERFROM IN number)
  is
  TOTAL number := 0;
  PERCENTAGE number := 0;
  PERHOUR number;
  EXCOUNT number := 0;

begin

  if USERFROM = 1 then
  	FOR R IN (select activity_type, sum(hour) as PERHOUR from weekly_activity_table_site where user_ID = USERID GROUP BY activity_type)  LOOP
    TOTAL := TOTAL + R.PERHOUR;
    if (R.activity_type ='education') then
      PERCENTAGE := PERCENTAGE + R.PERHOUR;
    end if;
	  END LOOP;

    select count(activity_date) into EXCOUNT from weekly_activity_table_site where user_ID = USERID 
    and activity_type = 'exercise' GROUP BY activity_type;
    
  else

  	FOR R IN (select activity_type, sum(hour) as PERHOUR from weekly_activity_table where user_ID = USERID GROUP BY activity_type)  LOOP
    TOTAL := TOTAL + R.PERHOUR;
    if (R.activity_type ='work' or R.activity_type ='skill develop') then
      PERCENTAGE := PERCENTAGE + R.PERHOUR;
    end if;
	  END LOOP;

    select count(activity_date) into EXCOUNT from weekly_activity_table where user_ID = USERID 
    and activity_type = 'exercise' GROUP BY activity_type;
    
  end if;

    if PERCENTAGE>85 then
      DBMS_OUTPUT.PUT_LINE('Over working.');
    end if;
    if (186-TOTAL)<49 then
      DBMS_OUTPUT.PUT_LINE('Not enough sleep through out the week.');
    end if;

    if EXCOUNT < 3 then
      DBMS_OUTPUT.PUT_LINE('Should exercise more then 2 days a week.');
    end if;

    if PERCENTAGE<56 OR (186-TOTAL)>84 then
      DBMS_OUTPUT.PUT_LINE('Free through out the week.');
      DBMS_OUTPUT.PUT_LINE('Can work on skill development.');
      DBMS_OUTPUT.PUT_LINE('Can engaged with more work.');
    end if;

end weekly_recomandation;
/