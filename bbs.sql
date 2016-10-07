use bbs;

create table user(
username varchar(20) not null,
userpassword varchar(20) not null,
id int not null primary key auto_increment
);

insert into user(username, userpassword) values('a', 'a');

insert into user(username, userpassword) values('b', 'b');

create table article(
articleid int not null primary key auto_increment,
title varchar(20) not null,
context varchar(50) not null,
articletime varchar(30) not null,
userid int);

insert into article(title, context, articletime, userid) 
	values('hello', 'world', '2016-09-29 22:00:00', 1);
    
create table comment(
commentid int not null primary key auto_increment,
commenttext varchar(100) not null,
commenttime varchar(30) not null,
userid int not null,
articleid int not null);

insert into comment(commenttext, commenttime, userid, articleid) 
values('abc', '2016-09-30 17:30:00', 1, 1);
