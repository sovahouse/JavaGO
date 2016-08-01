INSERT INTO public.employee (id, last_name, first_name, birth_date, phone, position, salary) VALUES (1, 'Anderson', 'Alex', '1993-07-02', null, 'waiter', 5000);
INSERT INTO public.employee (id, last_name, first_name, birth_date, phone, position, salary) VALUES (2, 'Polson', 'Robert', '1992-02-16', null, 'waiter', 6500);
INSERT INTO public.employee (id, last_name, first_name, birth_date, phone, position, salary) VALUES (3, 'Debian', 'James', '1986-10-23', null, 'cook', 10000);

INSERT INTO public.dish (id, name, category, price, weight) VALUES (1, 'Classic Chicken Salad', 'Salad', 60, 200);
INSERT INTO public.dish (id, name, category, price, weight) VALUES (2, 'Feta Pizza', 'Pizza', 70, 300);

INSERT INTO public.ingredient (name) VALUES ('Bacon');
INSERT INTO public.ingredient (name) VALUES ('Feta cheese');
INSERT INTO public.ingredient (name) VALUES ('Tomato');
INSERT INTO public.ingredient (name) VALUES ('Avocado ');
INSERT INTO public.ingredient (name) VALUES ('Dough');
INSERT INTO public.ingredient (name) VALUES ('Olive oil');
INSERT INTO public.ingredient (name) VALUES ('Olives');

INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (1, 'Bacon');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (1, 'Feta cheese');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (1, 'Tomato');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (1, 'Avocado ');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (2, 'Tomato');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (2, 'Dough');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (2, 'Olive oil');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (2, 'Feta cheese');
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_name) VALUES (2, 'Olives');


INSERT INTO public.menu (name) VALUES ('Pizza');
INSERT INTO public.menu (name) VALUES ('Salad');

INSERT INTO public.menu_list (dish_id, menu) VALUES (1, 'Salad');
INSERT INTO public.menu_list (dish_id, menu) VALUES (2, 'Pizza');