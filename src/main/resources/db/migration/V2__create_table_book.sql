CREATE  table Book
(
	id int auto_increment PRIMARY KEY,
	nome varchar(255) not null,
	price decimal(10,2) not null,
	status varchar(255) not null,
	customer_id int not null,
	foreign key(customer_id) REFERENCES Customer(id)

);