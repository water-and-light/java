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
	
/**用户**/
drop table if exists userinfo;
create table if not exists userinfo (
  user_id int(11) NOT NULL AUTO_INCREMENT primary key,
  user_name varchar(30),
  user_login varchar(30),
  user_passwd char(32) DEFAULT 'E10ADC3949BA59ABBE56E057F20F883E'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into userinfo(user_name,user_login,user_passwd) values
('张三','admin','8C7E1F3B1B787EC9F24FCC01E243E072');

/**商品**/
drop table if exists goods;
create table if not exists goods(
goods_id int AUTO_INCREMENT primary key,
goods_name varchar(50) not null,
goods_price int not null ,
goods_image varchar(100) not null,
goods_inventory int not null,
goods_type_id int not null,
goods_modifiedtime timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into goods(goods_name,goods_price,goods_image,goods_inventory,goods_type_id) values 
('华为/HUAWEI P40 6GB+128GB 亮黑色',4188,'http://127.0.0.1:9000/goods/b7a39258a56c411089177135c8dffc61.jpg',100,1);

/**商品种类**/
drop table if exists goodstype;
create table if not exists goodstype(
type_id int AUTO_INCREMENT primary key,
type_name varchar(20) not null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into goodstype (type_name) values ('手机');
insert into goodstype (type_name) values ('笔记本');

/**购物车**/
drop table if exists shoppingcart;
create table if not exists shoppingcart(
cart_id int AUTO_INCREMENT primary key,
student_id int not null,
goods_id int not null,
goods_num int not null
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;