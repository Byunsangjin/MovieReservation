CREATE TABLE customer (
	customer_UID INT(11) NOT NULL AUTO_INCREMENT,
    customer_id VARCHAR(20) Unique,
    customer_pw VARCHAR(20) NOT NULL,
    customer_name VARCHAR(20) NOT NULL,
    customer_tel VARCHAR(20),
    customer_genre VARCHAR(20),
    CONSTRAINT PK_customer PRIMARY KEY(
		customer_UID ASC,
        customer_id ASC
    )
);