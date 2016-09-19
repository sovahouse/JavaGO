INSERT INTO public.employee (id, surname, name, birth_date, phone, position, salary) VALUES (1, 'Anderson', 'Alex', '1993-07-02', '', 'WAITER', 5000);
INSERT INTO public.employee (id, surname, name, birth_date, phone, position, salary) VALUES (2, 'Polson', 'Robert', '1992-02-16', '', 'WAITER', 6500);
INSERT INTO public.employee (id, surname, name, birth_date, phone, position, salary) VALUES (3, 'Debian', 'James', '1986-10-23', '', 'COOK', 10000);
INSERT INTO public.employee (id, surname, name, birth_date, phone, position, salary) VALUES (4, 'Anderson', 'Jill', '1993-06-02', '', 'WAITER', 5000);

INSERT INTO public.dish (id, name, category, price, weight, photo) VALUES (1, 'Classic Chicken Salad', 'SALAD', 60, 200, '/resources/img/dishes/Classic_Chicken_Salad.png');
INSERT INTO public.dish (id, name, category, price, weight, photo) VALUES (2, 'Feta Pizza', 'PIZZA', 70, 300, '/resources/img/dishes/Feta_Pizza.jpg');

INSERT INTO public.ingredient (id, name) VALUES (1, 'Bacon');
INSERT INTO public.ingredient (id, name) VALUES (2, 'Feta cheese');
INSERT INTO public.ingredient (id, name) VALUES (3, 'Tomato');
INSERT INTO public.ingredient (id, name) VALUES (4, 'Avocado');
INSERT INTO public.ingredient (id, name) VALUES (5, 'Dough');
INSERT INTO public.ingredient (id, name) VALUES (6, 'Olive oil');
INSERT INTO public.ingredient (id, name) VALUES (7, 'Olives');

INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (1, 1);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (1, 2);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (1, 3);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (1, 4);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (2, 3);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (2, 5);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (2, 6);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (2, 2);
INSERT INTO public.ingredients_for_dish (dish_id, ingredient_id) VALUES (2, 7);

INSERT INTO public.store (id, quantity, ingredient_id) VALUES (1, 100, 1);
INSERT INTO public.store (id, quantity, ingredient_id) VALUES (2, 100, 2);
INSERT INTO public.store (id, quantity, ingredient_id) VALUES (3, 100, 3);
INSERT INTO public.store (id, quantity, ingredient_id) VALUES (4, 100, 4);
INSERT INTO public.store (id, quantity, ingredient_id) VALUES (5, 100, 5);
INSERT INTO public.store (id, quantity, ingredient_id) VALUES (6, 100, 6);
INSERT INTO public.store (id, quantity, ingredient_id) VALUES (7, 100, 7);


INSERT INTO public.menu (id, name) VALUES (1,'Pizza');
INSERT INTO public.menu (id, name) VALUES (2,'Salads');

INSERT INTO public.menu_list (dish_id, menu_id) VALUES (1, 2);
INSERT INTO public.menu_list (dish_id, menu_id) VALUES (2, 1);

