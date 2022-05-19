INSERT INTO product (description, product_name, size, unit_price)
VALUES (
    'visa card',
    'card',
    'large',
    24.0
  );
INSERT INTO product (description, product_name, size, unit_price)
VALUES (
    'master card',
    'card',
    'small',
    3200
  );
--@block
INSERT INTO inventory (quantity, product_id)
VALUES (
    42,
    1
  );