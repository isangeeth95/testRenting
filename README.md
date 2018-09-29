# yamudarawmak databse table queries

create database test1;



create table users(
uid int(11) primary key auto_increment,
fname varchar(50),
lname varchar(50),
email varchar(100),
gender varchar(10),
country varchar(50),
city varchar(50),
telNo varchar(20),
uname varchar(30),
password varchar(30),
imageName varchar(255),
path varchar(255)
);

ALTER TABLE users AUTO_INCREMENT=1;

create table driver(
username varchar(50) primary key,
fname varchar(50) not null,
lname varchar(50),
email varchar(50) not null,
NIC char(10) unique,
mobile int(11),
password varchar(50) not null
);