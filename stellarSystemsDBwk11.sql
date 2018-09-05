CREATE DATABASE IF NOT EXISTS stellarSystems;

USE stellarSystems;

DROP TABLE IF EXISTS solarSystem;
DROP TABLE IF EXISTS planets;

CREATE TABLE solarSystem (
	solarSystem_Id int(10) NOT NULL auto_increment,
	parentStarName nvarchar(30) NOT NULL, 
	galaxy nvarchar(30) NOT NULL,
	PRIMARY KEY(solarSystem_Id)
);

CREATE TABLE planets (
	planet_Id int(10) NOT NULL auto_increment,
	planetName nvarchar(20), 
	positionFromStar int(30),
	planetInfo nvarchar(50),
	solarSystem_Id int(10) NOT NULL,
	PRIMARY KEY(planet_Id),
	FOREIGN KEY(solarSystem_Id) REFERENCES solarSystem(solarSystem_Id)
);