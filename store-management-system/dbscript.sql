CREATE TABLE product_details (
					product_id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
					product_name varchar(20), 
					product_description varchar(200), 
					product_cost int, 
					product_image_url varchar(255));
					
INSERT INTO product_details(product_name, product_description, product_cost, product_image_url) VALUES ('Apples', 'Juicy Apples!', 15, '');

INSERT INTO product_details(product_name, product_description, product_cost, product_image_url) VALUES ('Bananas', 'Yummy Bananas!', 10, '');