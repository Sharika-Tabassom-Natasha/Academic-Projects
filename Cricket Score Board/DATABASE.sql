CREATE DATABASE SCOREBOARD;
USE SCOREBOARD;

CREATE TABLE loginTable(
LoginID int identity(1,1) primary key not null,
UserName Varchar(50) not null,
UserPassword varchar(50) unique not null,
);
---drop table loginTable--- 
select * from loginTable;


CREATE TABLE teamTable(
TeamID int identity(101,1),
TeamName varchar(100) primary key not null,
);
---drop table teamTable;---
select * from teamTable;

CREATE TABLE matchTable(
MatchID int identity(201,1) primary key not null,
MatchDate date not null,
TeamA varChar (100) not null,
TeamB varchar(100) not null,
);

---drop table matchTable;---
select * from matchTable;

CREATE TABLE playerInformationTable(
PlayerID int identity(301,1)  not null,
TeamName varchar(100) FOREIGN KEY REFERENCES teamTable(TeamName),
PlayerName varChar (100) not null,
PlayerStatus varChar (100) not null,
);
---drop table playerInformationTable;---
select * from playerInformationTable;

CREATE TABLE firstInningTable(
FirstInningsID int identity(601,1)  not null,
MatchID int  FOREIGN KEY REFERENCES matchTable(MatchID),
TeamName varchar(100) FOREIGN KEY REFERENCES teamTable(TeamName),
PlayerName varchar(100)  not null,
runTaken int null,
fours int null,
sixs int null,
ball int null,
noBall int null,
overs int null,
wicket int null,
runGiven int null,
);
---drop table firstInningTable;---
select * from firstInningTable;


CREATE TABLE secondInningTable(
SecondInningsID int identity(1001,1)  not null,
MatchID int  FOREIGN KEY REFERENCES matchTable(MatchID),
TeamName varchar(100) FOREIGN KEY REFERENCES teamTable(TeamName),
PlayerName varchar(100)  not null,
runTaken int null,
fours int null,
sixs int null,
ball int null,
noBall int null,
overs int null,
wicket int null,
runGiven int null,
);
---drop table secondInningTable;---
select * from secondInningTable;

CREATE TABLE playingTeamTable(
MatchID int  not null,
TeamName varchar(100) not null,
PlayerID int not null,
primary key(MatchID,TeamName,PlayerID),
);
---drop table aTeamTable;---
select * from playingTeamTable;



