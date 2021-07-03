
clear screen;

--delete existing table
drop table user_activity cascade constraints;
drop table user_table cascade constraints;
drop table activity cascade constraints;

create table user_table(
user_ID         integer, 
user_name       varchar2(50), 
user_password   varchar2(50), 
user_type       varchar2(50), 
		        PRIMARY KEY (user_ID)
);

create table activity(
activity_ID    	integer, 
activity_name  	varchar2(50), 
activity_type 	varchar2(50),
user_type 	    varchar2(50), 
			    PRIMARY KEY(activity_ID)
);

create table user_activity(
user_activity_ID    integer,
user_ID   		    integer, 
activity_ID   		integer, 
hour  	            integer,
activity_date  	    date,
short_note 	        varchar2(500),
                    PRIMARY KEY (user_activity_ID),
			        FOREIGN KEY(user_ID) REFERENCES user_table(user_ID), 
			        FOREIGN KEY(activity_ID) REFERENCES activity(activity_ID)
);
UPDATE user_activity SET short_note = NULL;

insert into user_table values(1,'Mary',123,'web developer');
insert into user_table values(2,'Susan',123,'doctor');
insert into user_table values(3,'Kashfi',123,'businessman');

insert into activity values(1,'javascript','skill develop','web developer');
insert into activity values(2,'django','skill develop','web developer');
insert into activity values(3,'php','skill develop','web developer');
insert into activity values(4,'project-1','work','web developer');
insert into activity values(5,'project-2','work','web developer');
insert into activity values(6,'football','entertainment','web developer');
insert into activity values(7,'games','entertainment','web developer');
insert into activity values(8,'instagram','entertainment','web developer');
insert into activity values(9,'television','entertainment','web developer');
insert into activity values(10,'yoga','exercise','web developer');

insert into activity values(11,'patient checkup','work','doctor');
insert into activity values(12,'operation-1','work','doctor');
insert into activity values(13,'operation-2','work','doctor');
insert into activity values(14,'operation-3','work','doctor');
insert into activity values(15,'operation-4','work','doctor');
insert into activity values(16,'family outing','entertainment','doctor');
insert into activity values(17,'social media','entertainment','doctor');
insert into activity values(18,'yoga','exercise','doctor');
insert into activity values(19,'jogging','exercise','doctor');
insert into activity values(20,'study','skill develop','doctor');

insert into user_activity values(1,1,4,8,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(2,1,6,1,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(3,1,3,2,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(4,1,7,1,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(5,1,8,2,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(6,1,4,3,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(7,1,8,1,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(8,1,4,2,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(9,1,8,5,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(10,1,6,3,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(11,1,3,6,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(12,1,8,1,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(13,1,4,7,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(14,1,8,1,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(15,1,9,2,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(16,1,10,1,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(17,1,3,3,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(18,1,9,1,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(19,1,4,9,to_date('17/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(20,1,7,2,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(21,1,3,8,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(22,1,6,1,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(23,1,4,4,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(24,1,2,8,to_date('20/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(25,1,10,1,to_date('20/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(50,1,4,10,to_date('20/09/2020', 'DD-MM-YYYY'),'.');


insert into user_activity values(26,2,11,6,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(27,2,16,2,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(28,2,11,5,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(29,2,16,2,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(30,2,11,7,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(31,2,17,1,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(32,2,11,5,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(33,2,17,3,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(34,2,11,6,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(35,2,18,2,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(36,2,11,7,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(37,2,18,1,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(38,2,12,8,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(39,2,18,2,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(40,2,11,5,to_date('17/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(41,2,18,1,to_date('17/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(42,2,11,7,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(43,2,12,5,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(44,2,19,1,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(45,2,11,4,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(46,2,13,6,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(47,2,16,2,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(48,2,14,7,to_date('20/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(49,2,19,1,to_date('20/09/2020', 'DD-MM-YYYY'),'.');

commit;