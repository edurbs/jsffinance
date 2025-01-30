create table person (
  id int not null auto_increment primary key,
  name varchar(100) not null
);

create table post (
  id int not null auto_increment primary key,
  typo varchar(20) not null,
  person_id int not null,
  description varchar(100) not null,
  amount decimal(10,2) not null,
  due_date date not null,
  paid bit not null,
  pay_date date,
  foreign key (person_id) references person (id)
);

insert into person (name) values ('João das Couves');
insert into person (name) values ('Tchau Telecom');
insert into person (name) values ('Pastelaria 99');
insert into person (name) values ('Panificadora do José');
insert into person (name) values ('Mercado Preço Bom');