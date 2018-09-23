# yamudarawmak

create database test1;

create table users(
uid int(11) primary key,
fname varchar(50),
lname varchar(50),
email varchar(100),
gender varchar(10),
country varchar(50),
city varchar(50),
telNo varchar(20),
uname varchar(30),
password varchar(30)
);

ALTER TABLE users AUTO_INCREMENT=1;
