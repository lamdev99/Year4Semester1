/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lamit
 * Created: Sep 25, 2020
 */
-- create
-- create
create database manageroom;
use manageroom;
create table tblUser(id integer primary key auto_increment,username varchar(20), _password varchar(20), position varchar(20));
create table tblRoom(id integer primary key auto_increment, nameroom varchar(20),_rank integer, priceperhour integer, des varchar(20));
create table tblClient(id integer primary key auto_increment,fullname varchar(20), idnumber integer, typeCard varchar(20), address varchar(20), des varchar(20));
create table tblBookRoom(id integer primary key auto_increment, idRoom integer , idClient integer, 
					timeCreate long, 
					timeStart long, 
                    timeEnd long,
                    timeCheckin long null,
                    timeCheckout long null,
                    foreign key(idRoom) references tblRoom(id),
                    foreign key(idClient) references tblClient(id));
create table tblBill(id integer primary key auto_increment,idBookRoom integer, total integer,
					foreign key(idBookRoom) references tblBookRoom(id));

create table tblPayment(id integer primary key auto_increment, idBill integer, payMoney integer, timePay long,
						foreign key(idBill) references tblBill(id));
--                         --insert
insert into tblUser(username,_password,position) values('1','1','manager');
insert into tblRoom(nameroom,_rank,priceperhour,des) values('101',5,150000,'single'), ('102',4,200000,'single');
insert into tblClient(fullname,idnumber,typeCard,address,des) values('lam',123,'TypeCardID','hanoi','vip'), ('nam',456,'TypeCardID','namdinh','vip');


