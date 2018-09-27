CREATE TABLE payment(
	payment_UID INT(6) NOT NULL auto_increment,
    total_price INT(6),
    payment_option VARCHAR(20),
    customer_ID VARCHAR(20),
    PRIMARY KEY(payment_UID)
);