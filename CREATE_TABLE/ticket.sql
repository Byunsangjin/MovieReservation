CREATE TABLE ticket(
	ticket_UID INT(6) NOT NULL auto_increment,
	customer_UID VARCHAR(20),
	totalnum INT(6),
	selectseat VARCHAR(20),
	totalticket_price INT(6),
    PRIMARY KEY(ticket_UID)
);