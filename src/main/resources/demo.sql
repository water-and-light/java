set names gbk;

drop database if exists card;
create database if not exists card;
use card;

/**院系**/
drop table if exists college;
create table if not exists college(
	college_id int not null primary key auto_increment,
	college_name varchar(20) not null
);
insert into college(college_name) values('软件工程系');
insert into college(college_name) values('网络工程系');
insert into college(college_name) values('数学系');

/**学生**/
drop table if exists student;
create table if not exists student(
	stu_id int not null primary key auto_increment,
	stu_no char(12) not null,
	stu_name varchar(16) not null,
	stu_login varchar(16) not null unique,
	stu_passwd char(32) not null,
	stu_phone char(11),
	stu_limit int default 1,
	stu_remain int,
	stu_note varchar(100),
	college_id int
);
insert into student(stu_no,stu_name,stu_login ,stu_passwd ,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806001','张三','admin','123456','13812282811',666,'1班学生',1); 
insert into student(stu_no,stu_name,stu_login ,stu_passwd ,stu_phone,stu_remain,stu_note,college_id)
	values('STU201806002','李四','root','123456','13812282812',66,'1班学生',1); 
	
select * from student where stu_name REGEXP '^张三[1-9]{0,1}$';
select count(stu_id) from student where stu_name REGEXP '^张三[1-9]{0,2}$';
	
drop table if exists detailtype; 

/**费用类型**/
create table if not exists detailtype(
	type_id int not null primary key auto_increment,
	type_name varchar(20) not null
);
insert into detailtype(type_name) values('充值');
insert into detailtype(type_name) values('消费');

/**费用**/
drop table if exists detail;
create table if not exists detail(
	detail_id int not null primary key auto_increment,
	detail_stuserial char(36) unique not null,
	detail_time datetime,
	detail_money int,
	detail_title varchar(60),
	stu_id int,
	type_id int
);

insert into detail(detail_stuserial,detail_time,detail_money,detail_title,stu_id,type_id)
	values('ea986ed0-f523-4bca-bedb-9b4357253e20',now(),10,'饮食',1,2);
insert into detail(detail_stuserial,detail_time,detail_money,detail_title,stu_id,type_id)
	values('8598cdd0-611d-48f7-b338-64defbb60011',now(),20,'娱乐',1,2);
	
/**用户**/
drop table if exists userinfo;
create table if not exists userinfo (
  user_id int(11) NOT NULL AUTO_INCREMENT primary key,
  user_name varchar(30),
  user_login varchar(30),
  user_passwd char(32) DEFAULT 'E10ADC3949BA59ABBE56E057F20F883E'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into userinfo(user_name,user_login,user_passwd) values
('张三','zhangsan','8C7E1F3B1B787EC9F24FCC01E243E072');