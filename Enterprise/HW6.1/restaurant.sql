﻿create table EMPLOYEE(
	ID int primary key not null,
	SURNAME text not null,
	NAME text not null,
	BIRTH_DATE date,
	PHONE text,
	POSITION text,
	SALARY real
);

commit;


create table DISH(
	ID int primary key not null,
	NAME text,
	CATEGORY text,
	PRICE real,
	WEIGHT double precision
	
);



commit;

create table INGREDIENTS_FOR_DISH(
	--DISH
	--ingedient
);



create table ORD(
	ID int primary key not null,
	--employee
	TABLE_NUMBER int,
	DATE date,
	OPEN_STATUS BOOL
);



commit;

create table MENU_LIST(
	--MENU
	--DISH
);

create table MENU(
	NAME text primary key not null,
	ID int
);



create table INGREDIENT(
	NAME text primary key not null
);


create table STORE(
	ID int primary key not null,
	QUANTITY int
);

CREATE TABLE DISH_TO_ORDER(

);



ALTER TABLE INGREDIENTS_FOR_DISH ADD COLUMN DISH_ID int;
ALTER TABLE INGREDIENTS_FOR_DISH ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID); 
ALTER TABLE INGREDIENTS_FOR_DISH ADD COLUMN INGREDIENT_NAME text;
ALTER TABLE INGREDIENTS_FOR_DISH ADD CONSTRAINT INGREDIENT_NAME_FK FOREIGN KEY (INGREDIENT_NAME) REFERENCES INGREDIENT (NAME);

ALTER TABLE ORD ADD COLUMN EMPLOYEE_ID int;
ALTER TABLE ORD ADD CONSTRAINT EMPLOYEE_ID_FK FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID);

ALTER TABLE MENU_LIST ADD COLUMN DISH_ID int;
ALTER TABLE MENU_LIST ADD COLUMN MENU text;
ALTER TABLE MENU_LIST ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID);
ALTER TABLE MENU_LIST ADD CONSTRAINT MENU_FK FOREIGN KEY (MENU) REFERENCES MENU (NAME);

ALTER TABLE STORE ADD COLUMN INGREDIENT_NAME text;
ALTER TABLE STORE ADD CONSTRAINT INGREDIENT_NAME_FK FOREIGN KEY (INGREDIENT_NAME) REFERENCES INGREDIENT (NAME);

ALTER TABLE DISH_TO_ORDER ADD COLUMN DISH_ID int;
ALTER TABLE DISH_TO_ORDER ADD COLUMN ORDER_ID int;
ALTER TABLE DISH_TO_ORDER ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID);
ALTER TABLE DISH_TO_ORDER ADD CONSTRAINT ORDER_ID_FK FOREIGN KEY (ORDER_ID) REFERENCES ORD (ID);
