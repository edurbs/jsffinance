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
