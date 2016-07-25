﻿create table EMPLOYEE(
	ID int primary key not null,
	LAST_NAME text not null,
	FIRST_NAME text not null,
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
	ORDER_ID int primary key not null,
	--employee
	--DISH
	TABLE_NUMBER int,
	DATE date
);

create table PREPARED_DISHES(
	ID int primary key not null,
	DISHES_NUMBER real not null,
	--DISH,
	--Employee
	--Ord
	DATE date
);




commit;

create table MENU_LIST(
	--MENU
	--DISH
);

create table MENU(
	NAME text primary key not null
);



create table INGREDIENT(
	NAME text primary key not null
);


create table STORE(
	NAME text primary key not null
);


create table STORES(
	ID int primary key not null,
	QUANTITY int
);


ALTER TABLE INGREDIENTS_FOR_DISH ADD COLUMN DISH_ID int;
ALTER TABLE INGREDIENTS_FOR_DISH ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID); 
ALTER TABLE INGREDIENTS_FOR_DISH ADD COLUMN INGREDIENT_NAME text;
ALTER TABLE INGREDIENTS_FOR_DISH ADD CONSTRAINT INGREDIENT_NAME_FK FOREIGN KEY (INGREDIENT_NAME) REFERENCES INGREDIENT (NAME);

ALTER TABLE ORD ADD COLUMN EMPLOYEE_ID int;
ALTER TABLE ORD ADD COLUMN DISH_ID int;

ALTER TABLE ORD ADD CONSTRAINT EMPLOYEE_ID_FK FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID);
ALTER TABLE ORD ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID);

ALTER TABLE PREPARED_DISHES ADD COLUMN EMPLOYEE_ID int;
ALTER TABLE PREPARED_DISHES ADD COLUMN DISH_ID int;
ALTER TABLE PREPARED_DISHES ADD COLUMN ORDER_ID int;

ALTER TABLE PREPARED_DISHES ADD CONSTRAINT EMPLOYEE_ID_FK FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID);
ALTER TABLE PREPARED_DISHES ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID);
ALTER TABLE PREPARED_DISHES ADD CONSTRAINT ORDER_ID_FK FOREIGN KEY (ORDER_ID) REFERENCES ORD (ORDER_ID);

ALTER TABLE MENU_LIST ADD COLUMN DISH_ID int;
ALTER TABLE MENU_LIST ADD COLUMN MENU text;
ALTER TABLE MENU_LIST ADD CONSTRAINT DISH_ID_FK FOREIGN KEY (DISH_ID) REFERENCES DISH (ID);
ALTER TABLE MENU_LIST ADD CONSTRAINT MENU_FK FOREIGN KEY (MENU) REFERENCES MENU (NAME);

ALTER TABLE STORES ADD COLUMN STORE_NAME text;
ALTER TABLE STORES ADD COLUMN INGREDIENT_NAME text;
ALTER TABLE STORES ADD CONSTRAINT STORE_NAME_FK FOREIGN KEY (STORE_NAME) REFERENCES INGREDIENT (NAME);
ALTER TABLE STORES ADD CONSTRAINT INGREDIENT_NAME_FK FOREIGN KEY (INGREDIENT_NAME) REFERENCES INGREDIENT (NAME);