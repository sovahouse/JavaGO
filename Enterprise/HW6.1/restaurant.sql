﻿create table EMPLOYEE(
	ID int primary key not null,
	SURNAME text not null,
	NAME text not null,
	BIRTH_DATE date,
	PHONE text,
	POSITION text,
	SALARY real,
	DTYPE VARCHAR
);

commit;


create table DISH( /*FOR OPENED ORDERS*/
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

create table PREPARED_DISHES(  /*FOR CLOSED ORDERS*/
	ID int primary key not null,
	--DISH,
	--Employee
	DATE date
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

CREATE TABLE PREPARED_DISH_TO_ORDER(

);


ALTER TABLE INGREDIENTS_FOR_DISH ADD COLUMN DISH_ID int;
ALTER TABLE INGREDIENTS_FOR_DISH ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID); 
ALTER TABLE INGREDIENTS_FOR_DISH ADD COLUMN INGREDIENT_NAME text;
ALTER TABLE INGREDIENTS_FOR_DISH ADD CONSTRAINT INGREDIENT_NAME_FK FOREIGN KEY (INGREDIENT_NAME) REFERENCES INGREDIENT (NAME);


ALTER TABLE PREPARED_DISHES ADD COLUMN COOK_ID int;
ALTER TABLE PREPARED_DISHES ADD COLUMN DISH_ID int;

ALTER TABLE PREPARED_DISHES ADD CONSTRAINT COOK_ID_FK FOREIGN KEY (COOK_ID) REFERENCES EMPLOYEE (ID);
ALTER TABLE PREPARED_DISHES ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID);

ALTER TABLE ORD ADD COLUMN WAITER_ID int;
ALTER TABLE ORD ADD COLUMN COOK_ID int;
ALTER TABLE ORD ADD CONSTRAINT WAITER_ID_FK FOREIGN KEY (WAITER_ID) REFERENCES EMPLOYEE (ID);
ALTER TABLE ORD ADD CONSTRAINT COOK_ID_FK FOREIGN KEY (COOK_ID) REFERENCES EMPLOYEE (ID);

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

ALTER TABLE PREPARED_DISH_TO_ORDER ADD COLUMN PREPARED_DISH_ID int;
ALTER TABLE PREPARED_DISH_TO_ORDER ADD COLUMN ORDER_ID int;
ALTER TABLE PREPARED_DISH_TO_ORDER ADD CONSTRAINT PREPARED_DISH_ID_FK FOREIGN KEY (PREPARED_DISH_ID) REFERENCES PREPARED_DISHES (ID);
ALTER TABLE PREPARED_DISH_TO_ORDER ADD CONSTRAINT ORDER_ID_FK FOREIGN KEY (ORDER_ID) REFERENCES ORD (ID);