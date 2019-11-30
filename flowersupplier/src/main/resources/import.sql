INSERT INTO supplier.product (description, name, price, province) VALUES('Flores', 'Flores', 5.00, 'SP');
INSERT INTO supplier.product (description, name, price, province) VALUES('Mato', 'Mato', 1.00, 'GO');
INSERT INTO supplier.product (description, name, price, province) VALUES('Terra', 'Terra', 0.50, 'MG');

INSERT INTO supplier.supplier_info (address, name, province) VALUES('Rua do Florista', 'Seu João', 'SP');
INSERT INTO supplier.supplier_info (address, name, province) VALUES('Rua do Treteiro', 'Seu Carlos', 'GO');
INSERT INTO supplier.supplier_info (address, name, province) VALUES('Rua do Vendedor de Terra', 'Seu Tobias', 'MG');

INSERT INTO supplier.order_info (fulfillment_time, order_status) VALUES(2, 'RECEIVED');
INSERT INTO supplier.order_info (fulfillment_time, order_status) VALUES(1, 'RECEIVED');
INSERT INTO supplier.order_info (fulfillment_time, order_status) VALUES(4, 'RECEIVED');
