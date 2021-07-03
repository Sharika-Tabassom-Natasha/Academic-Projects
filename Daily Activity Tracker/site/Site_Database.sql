
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


insert into user_table values(4,'sharika',123,'Undergraduate');
insert into user_table values(5,'tabassom',123,'Undergraduate');

insert into activity values(21,'thesis','education','Undergraduate');
insert into activity values(22,'course','education','Undergraduate');
insert into activity values(23,'lab','education','Undergraduate');
insert into activity values(24,'games','entertainment','Undergraduate');
insert into activity values(25,'instagram','entertainment','Undergraduate');
insert into activity values(26,'facebook','entertainment','Undergraduate');
insert into activity values(27,'family outing','entertainment','Undergraduate');
insert into activity values(28,'cricket','entertainment','Undergraduate');
insert into activity values(29,'mountain climb','exercise','Undergraduate');
insert into activity values(30,'jogging','exercise','Undergraduate');
insert into activity values(31,'yoga','exercise','Undergraduate');



insert into user_activity values(51,4,24,4,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(52,4,26,1,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(53,4,23,2,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(54,4,27,1,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(55,4,28,2,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(56,4,24,3,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(57,4,28,1,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(58,4,24,2,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(59,4,28,5,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(60,4,26,3,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(61,4,23,6,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(62,4,28,1,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(63,4,24,7,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(64,4,28,1,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(65,4,29,1,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(66,4,30,1,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(67,4,23,3,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(68,4,29,1,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(69,4,24,9,to_date('17/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(70,4,27,2,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(71,4,23,4,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(72,4,26,1,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(73,4,24,4,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(74,4,22,10,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(75,4,22,1,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(100,4,21,8,to_date('20/09/2020', 'DD-MM-YYYY'),'.');

insert into user_activity values(76,5,21,6,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(77,5,26,2,to_date('10/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(78,5,31,5,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(79,5,21,2,to_date('11/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(80,5,31,7,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(81,5,27,1,to_date('12/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(82,5,31,5,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(83,5,21,3,to_date('13/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(84,5,31,6,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(85,5,28,2,to_date('14/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(86,5,31,7,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(87,5,21,1,to_date('15/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(88,5,22,8,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(89,5,28,2,to_date('16/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(90,5,31,5,to_date('17/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(91,5,28,1,to_date('17/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(92,5,25,7,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(93,5,22,5,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(94,5,29,1,to_date('18/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(95,5,24,4,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(96,5,23,6,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(97,5,26,2,to_date('19/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(98,5,21,7,to_date('20/09/2020', 'DD-MM-YYYY'),'.');
insert into user_activity values(99,5,29,1,to_date('20/09/2020', 'DD-MM-YYYY'),'.');

commit;