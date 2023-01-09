CREATE table purchase
(
	    id int auto_increment PRIMARY KEY,
        customer_id int not null,
        nfe varchar(255),
    	price decimal(10,2) not null,
    	created_at DATETIME not null,
        foreign key(customer_id) REFERENCES customer(id)

);

CREATE table purchase_book
(
    purchase_id int not null,
    book_id int not null,
    foreign key(purchase_id) REFERENCES  purchase(id),
    foreign key(book_id) REFERENCES book(id),
    PRIMARY KEY(purchase_id,book_id)
);