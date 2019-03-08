//TABLE 1
create table passenger(
mail_id varchar2(20) not null,
password varchar2(20) not null,
name varchar2(20) not null,
gender varchar2(10) not null,
age number not null,
mobile_number number not null, 
constraint pass_mail_id_pk primary key(mail_id));

ALTER TABLE passenger ADD CHECK (age>0);

SELECT * FROM passenger;

create sequence pass_no_seq starts with 1 increment by 1;

//TABLE 2
create table trains(
id int,
name varchar2(20) not null,
source varchar2(20) not null,
destination varchar2(20) not null,
duration varchar2(10) not null,
category varchar2(10) not null,
price number(4,2) not null,
constraint tr_id_pk primary key(id));

ALTER TABLE trains ADD CHECK (price>0);

select * from trains;

//TABLE 3
create table JourneyDetail(name varchar2(20),gender varchar2(10),age number,mobile_number number,seats int(10),total number(4,2));
select *from JourneyDetail;