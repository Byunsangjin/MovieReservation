CREATE TABLE seat
(
	theater_UID INT(6) NOT NULL auto_increment,
    seat_UID VARCHAR(10) NOT NULL,
    booking INT,
    CONSTRAINT PK_customer PRIMARY KEY(
		theater_UID ASC
    )
);