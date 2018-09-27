CREATE TABLE snack_order
(
	s_order_UID INT(6) NOT NULL AUTO_INCREMENT,
    customer_id VARCHAR(20),
    p_snack_ID VARCHAR(20),
    b_snack_ID VARCHAR(20),
    CONSTRAINT PK_customer PRIMARY KEY(
		s_order_UID ASC
    )
);