INSERT INTO feature (id, description) VALUES (1, 'Pantalla táctil') ON DUPLICATE KEY UPDATE id=id;
INSERT INTO feature (id, description) VALUES (2, 'Conectividad Bluetooth') ON DUPLICATE KEY UPDATE id=id;
INSERT INTO feature (id, description) VALUES (3, 'Cámara de alta resolución') ON DUPLICATE KEY UPDATE id=id;

INSERT INTO product (id, name, price, imageUrl) VALUES (1, 'Smartphone XYZ', 799.99, 'https://marketplace-allinone.s3.amazonaws.com/smartphone.jpg') ON DUPLICATE KEY UPDATE id=id;
INSERT INTO product (id, name, price, imageUrl) VALUES (2, 'Laptop ABC', 1200.00, 'https://marketplace-allinone.s3.amazonaws.com/laptop.jpg') ON DUPLICATE KEY UPDATE id=id;

INSERT INTO product_features (product_id, features_id) VALUES (1, 1) ON DUPLICATE KEY UPDATE product_id=product_id, features_id=features_id;
INSERT INTO product_features (product_id, features_id) VALUES (1, 2) ON DUPLICATE KEY UPDATE product_id=product_id, features_id=features_id;
INSERT INTO product_features (product_id, features_id) VALUES (2, 2) ON DUPLICATE KEY UPDATE product_id=product_id, features_id=features_id;
INSERT INTO product_features (product_id, features_id) VALUES (2, 3) ON DUPLICATE KEY UPDATE product_id=product_id, features_id=features_id;

