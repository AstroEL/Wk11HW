CREATE DATABASE IF NOT EXISTS leagues;
USE leagues;

DROP TABLE IF EXISTS leagues;
DROP TABLE IF EXISTS teams;

CREATE TABLE leagues(
	id int(10) NOT NULL auto_increment,
	leagueName nvarchar(25) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE teams(
	id int(10) NOT NULL auto_increment,
	teamCity nvarchar(25) NOT NULL,
	teamName nvarchar(25) NOT NULL,
	league_Id int(50),
	PRIMARY KEY(id),
	FOREIGN KEY(league_Id) REFERENCES leagues(id)
);













