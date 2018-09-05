CREATE DATABASE IF NOT EXISTS planets;

USE planets;

DROP TABLE IF EXISTS planetInfo;
DROP TABLE IF EXISTS planets;

CREATE TABLE planets (
	id int(10)	NOT NULL auto_increment,
	name nvarchar(30) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE planetInfo (
	id int(10) NOT NULL auto_increment,
	pos_sun nvarchar(20),
	planet_size nvarchar(20),
	deets nvarchar(60),
	planet_id int(10) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(planet_id) REFERENCES planets(id)
);