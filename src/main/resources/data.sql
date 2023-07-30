INSERT INTO users (user_id, email, password, first_name, last_name) VALUES ('4e9154e1-0953-4dbe-9b02-115b0b23c3fc', 'juanesguti19@gmail.com', '$2a$12$N.xjDrN4bl3AMks9vS9A/Oh1EfxkvNMkI/lOwW97u1JM84GqatBje', 'Juan', 'Gutierrez');

INSERT INTO items (item_id, label, description, price, stock_quantity) VALUES ('552365b2-0846-4502-84fc-81df70c19757', 'Camiseta Nike XL', 'Camiseta puma manga corta. Muy buena opción para hacer deporte.', '150000.00', 2);
INSERT INTO items (item_id, label, description, price, stock_quantity) VALUES ('7048853d-a5ef-4f10-bc77-0d79a2032b9c', 'Botas punta de seguridad', 'Nueva colección botas punta de seguridad composite para mujer cosidas, fabricación nacional.', '130000.00', 3);
INSERT INTO items (item_id, label, description, price, stock_quantity) VALUES ('843aeba7-b452-48d5-bb00-2e356e0350de', 'Reloj pulsera Invicta', 'Llegar tarde a tus compromisos ya no es opción, con este reloj pulsera cumple con todos horarios y no te pierdas ningún evento importante. Súmale estilo a tu outfit, es el complemento ideal.', '289900.00', 0);

INSERT INTO wishlist_items (wishlist_items_id, user_id, item_id, note, added_date, enabled) VALUES ('bab7eed1-879d-4073-b795-e1856e91bd58', '4e9154e1-0953-4dbe-9b02-115b0b23c3fc', '552365b2-0846-4502-84fc-81df70c19757', 'Un regalo para mi hijo', '2023-06-15 00:00:00.000', 'TRUE');
INSERT INTO wishlist_items (wishlist_items_id, user_id, item_id, note, added_date, enabled) VALUES ('aa25a718-138e-4c9a-9229-c88e0c3f8cfa', '4e9154e1-0953-4dbe-9b02-115b0b23c3fc', '7048853d-a5ef-4f10-bc77-0d79a2032b9c', 'Unas botas para mi hermana', '2023-06-15 00:00:00.000', 'TRUE');
INSERT INTO wishlist_items (wishlist_items_id, user_id, item_id, note, added_date, enabled) VALUES ('e847331c-1872-4268-8426-4bd3d8f01ef6' ,'4e9154e1-0953-4dbe-9b02-115b0b23c3fc', '7048853d-a5ef-4f10-bc77-0d79a2032b9c', 'Reloj para mi padre', '2023-06-15 00:00:00.000', 'TRUE');
INSERT INTO wishlist_items (wishlist_items_id, user_id, item_id, note, added_date, enabled) VALUES ('4730865a-e2db-462f-a836-250fa809e110', '4e9154e1-0953-4dbe-9b02-115b0b23c3fc', '7048853d-a5ef-4f10-bc77-0d79a2032b9c', 'Relojito para mi prima Andrea', '2023-06-15 00:00:00.000', 'FALSE');