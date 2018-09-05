CREATE DATABASE IF NOT EXISTS characterMaker;

USE characterMaker;

DROP TABLE IF EXISTS Classes;
DROP TABLE IF EXISTS Abilities;
DROP TABLE IF EXISTS Lore;
DROP TABLE IF EXISTS Transportation;
DROP TABLE IF EXISTS Weapons;
DROP TABLE IF EXISTS Pets;

-- WHAT'S UP TEAM!  OK - HERE IS WHERE YOU WILL ADD YOUR TABLES FOR YOUR ASSIGNED OBJECTS. -L

CREATE TABLE classes (
	class_Id int(10) NOT NULL auto_increment,
	className nvarchar(25),
	-- Barbarian, Wizard, SpecOps, Monk, Priest
	classDescription nvarchar(250),
	classPerks nvarchar(250),
	classWeakness nvarchar(250),
	PRIMARY KEY(class_Id),	
)

CREATE TABLE ablilities (
	ability_Id int(50) NOT NULL auto_increment,
	abilityName nvarchar(25),
	abilityType nvarchar(25),
	-- Melee, Projectile, Defensive, Dodge, Psychic, 
	abilityDescription nvarchar(250),
	abilityClass_Id int(10),
	PRIMARY KEY(ability_Id),
	FOREIGN KEY(abilityClass_Id) REFERENCES classes(class_Id)
)