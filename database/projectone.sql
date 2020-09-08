DROP TABLE IF EXISTS status CASCADE;

CREATE TABLE status(
reim_statid integer PRIMARY KEY NOT NULL ,
reim_status varchar(20) NOT NULL 
);

INSERT INTO status(reim_statid, reim_status)
VALUES( 10,'approved'),
	(11,'pending'),
	(12,'denied');

DROP TABLE IF EXISTS reim_type CASCADE;

CREATE TABLE reim_type(
typeid integer PRIMARY KEY NOT NULL ,
reim_tp varchar(20) NOT NULL 
);
INSERT INTO reim_type(typeid, reim_tp)
VALUES( 1,'lodging'),
	  (2,'travel'),
	  (3,'food'),
	  (4,'other');

DROP TABLE IF EXISTS userRl CASCADE;

CREATE TABLE userRl(
useroleid integer PRIMARY KEY NOT NULL ,
userole varchar(20) NOT NULL 
);
INSERT INTO userRl(useroleid, userole)
values(1,'empl'),
	  (2,'mangr');

	 DROP TABLE IF EXISTS Users CASCADE;

CREATE TABLE Users(
userid serial PRIMARY KEY NOT NULL ,
usrnm varchar(50) NOT NULL ,
usrpaswd varchar(50) NOT NULL ,
usr_fname varchar(100) NOT NULL ,
usr_lname varchar(100) NOT NULL ,
usreml varchar(150),
usr_rlid integer REFERENCES userRl(useroleid) NOT NULL,
unique(usrnm,usreml) 
);
INSERT INTO Users(usrnm,usrpaswd,usr_fname,usr_lname,usreml,usr_rlid)
values('dog','sky','Ethan','Hunt','dog1@msn',1 ),
	  ('cat','sky','Julia','Roberts','dog2@msn',2),
	  ('handsome','sky','Edward','Norton','dog3@msn',1),
	  ('cute','sky','Brad','Pitt','dog4@msn',2),
	  ('cong','sky','Sandra','Bullock','dog5@msn', 1);


DROP TABLE IF EXISTS reimbursement CASCADE;

CREATE TABLE reimbursement(
reimb_id serial PRIMARY KEY NOT null,
reimb_amt integer NOT null,
reim_submtd timestamp,
reim_resolvd timestamp,
reim_recpt bytea,
reim_desc varchar(20),
reim_athr integer REFERENCES Users(userid) NOT NULL ,
reim_resolr integer REFERENCES Users(userid) ,
reim_stts integer REFERENCES status(reim_statid) NOT null,
reim_numb integer REFERENCES reim_type(typeid) NOT null 
);

INSERT INTO reimbursement (reimb_amt ,reim_desc ,reim_athr ,reim_stts,reim_numb )
VALUES (20,'test',1,10,3),
(30,'test2',2,11,4),
(40,'test3',3,12,3);
