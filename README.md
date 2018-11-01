# Session attributes

session.setAttribute("loggedAs", "user");
session.setAttribute("uid", dbUid);
session.setAttribute("username", dbuname);
session.setAttribute("password", dbpassword);
session.setAttribute("imageName", imageName);


# create yamudarawmak databse

create database test1;

# create admins table

create table admins(
adminId int(11) primary key auto_increment,
fname varchar(50),
lname varchar(50),
email varchar(100),
gender varchar(10),
country varchar(50),
city varchar(50),
telNo varchar(20),
uname varchar(30) unique,
password varchar(30),
imageName varchar(255),
path varchar(255)
);

ALTER TABLE admins AUTO_INCREMENT=1;

insert into admins (fname,lname,email,gender,country,city,telNo,uname,password,imageName,path) values("sangeeth","sankalpa","sangeeth","male","SL","madampe","+94775240944","admin1","111","","");

# create users table

create table users(
uid int(11) primary key auto_increment,
fname varchar(50),
lname varchar(50),
email varchar(100),
gender varchar(10),
country varchar(50),
city varchar(50),
telNo varchar(20),
uname varchar(30) unique,
password varchar(30),
imageName varchar(255),
path varchar(255)
);

ALTER TABLE users AUTO_INCREMENT=1;

# create driver table

create table driver(
username varchar(50) primary key,
fname varchar(50) not null,
lname varchar(50),
email varchar(50) not null,
NIC char(10) unique,
mobile int(11),
password varchar(50) not null
);

ALTER TABLE driver ADD image VARCHAR(1000) ;
ALTER TABLE driver ADD path VARCHAR(1000) ;

# create table for driver requests

CREATE TABLE `driverrequest` (
  `username` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  `reason` varchar(450) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `driver` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

# create trigger to delete driver

DELIMITER $$
CREATE TRIGGER T1 BEFOR DELETE
ON test1.driver
FOR EACH ROW BEGIN
DELETE FROM driverrequest ;
END $$





--------------------------


------------------------------------------------
# create vehicle table

create table vehicle(
	uid varchar(5),
	vehicle varchar(10),
    type varchar(20) not null,
    model varchar(6)  primary key,
    vImage varchar(255), 
    path varchar(255),
	hire real,
    ac varchar(10) default 'Available',
    bar varchar(10) default 'Available',
    reason varchar(50) default 'Wedding, Airport Hire, For other functions',
    place varchar(20) default 'All-Island');

# create rentVehicles table

create table rentVehicles(
vehicleId int(5) primary key auto_increment,
type varchar(50),
costPerDay varchar(255),
costPerKM varchar(255),
imageName varchar(255),
path varchar(255),
rentCategory varchar(255)
);

ALTER TABLE rentVehicles AUTO_INCREMENT=1;

# -----create shopping cart table

create table shoppingCart(
orderId int(5) primary key auto_increment,
userId int(5),
vehicleId int(5),
rentCategory varchar(255),
duration varchar(255),
cost varchar(255)
);

ALTER TABLE shoppingCart AUTO_INCREMENT=1;