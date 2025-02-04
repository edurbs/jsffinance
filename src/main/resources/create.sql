CREATE USER 'root'@'%' IDENTIFIED BY 'some_pass';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';

CREATE DATABASE `jsffinance` ;

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

ALTER TABLE jsffinance.person ADD person_type varchar(100) NULL;
ALTER TABLE jsffinance.person ADD email varchar(100) NULL;
ALTER TABLE jsffinance.person ADD birthday DATE NULL;
ALTER TABLE jsffinance.person ADD bussines_line varchar(100) NULL;
ALTER TABLE jsffinance.person CHANGE bussines_line business_line varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL;
ALTER TABLE `jsffinance`.`post` CHANGE COLUMN `typo` `type` VARCHAR(20) NOT NULL ;


CREATE TABLE jsffinance.NewTable (
	id INTEGER auto_increment NOT NULL,
	description varchar(100) NOT NULL,
	CONSTRAINT NewTable_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;
RENAME TABLE jsffinance.NewTable TO jsffinance.business_line;

ALTER TABLE jsffinance.person DROP COLUMN business_line;
ALTER TABLE jsffinance.person ADD business_line_id INTEGER NULL;
ALTER TABLE jsffinance.person ADD CONSTRAINT person_business_line_FK FOREIGN KEY (business_line_id) REFERENCES jsffinance.business_line(id);

--  Auto-generated SQL script #202501311426
INSERT INTO jsffinance.business_line (id,description)
	VALUES (1,'Frutas');
INSERT INTO jsffinance.business_line (id,description)
	VALUES (2,'Legumes');
INSERT INTO jsffinance.business_line (id,description)
	VALUES (3,'Verduras');
INSERT INTO jsffinance.business_line (id,description)
	VALUES (4,'Carnes');

--  Auto-generated SQL script #202501311439
UPDATE jsffinance.person
	SET birthday='2001/12/30',person_type='INDIVIDUAL',email='asd@asd.com',business_line_id=1
	WHERE id=1;
UPDATE jsffinance.person
	SET birthday='2001/12/30',person_type='COMPANY',email='asd@asd.com',business_line_id=2
	WHERE id=2;
UPDATE jsffinance.person
	SET birthday='2001/12/30',person_type='COMPANY',email='asd@asd.com',business_line_id=3
	WHERE id=3;
UPDATE jsffinance.person
	SET birthday='2001/12/30',person_type='COMPANY',email='asd@asd.com',business_line_id=4
	WHERE id=4;
UPDATE jsffinance.person
	SET birthday='2001/12/30',person_type='COMPANY',email='asd@asd.com',business_line_id=1
	WHERE id=5;

create table user_name (
   user_name varchar(15) not null primary key,
   password varchar(15) not null
);

create table user_permission (
   user_name	varchar(15) not null,
   permission_name varchar(15) not null, 
   primary key (user_name, permission_name),
   foreign key (user_name) references user_name (user_name)
);

insert into user_name values ('joao', 'joao');
insert into user_name values ('maria', 'maria');
insert into user_name values ('sebastiao', 'sebastiao');

insert into user_permission values ('joao', 'edit');
insert into user_permission values ('maria', 'read');
insert into user_permission values ('sebastiao', 'edit');
insert into user_permission values ('sebastiao', 'read');

ALTER TABLE jsffinance.user_name MODIFY COLUMN password varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL;

update user_name set password = md5(password);
