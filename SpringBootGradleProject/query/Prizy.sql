CREATE SCHEMA Prizy DEFAULT CHARACTER SET utf8;

CREATE USER 'PrizyUser' IDENTIFIED BY 'password';

GRANT ALL ON Prizy.* TO 'PrizyUser';

create table Prizy.Products (id INT AUTO_INCREMENT PRIMARY KEY, BarCode int unique not null, Discription varchar(255));

select * from Prizy.Products;

INSERT INTO Prizy.Products (BarCode, Discription)
VALUES (1111, 'Coffee');
INSERT INTO Prizy.Products (BarCode, Discription)
VALUES (2222, 'Oil');
INSERT INTO Prizy.Products (BarCode, Discription)
VALUES (3333, 'Pastas');
INSERT INTO Prizy.Products (BarCode, Discription)
VALUES (4444, 'Tea');
INSERT INTO Prizy.Products (BarCode, Discription)
VALUES (5555, 'Chocolates');
INSERT INTO Prizy.Products (BarCode, Discription)
VALUES (6666, 'Milk');


create table Prizy.Store (Store varchar(10) not null, BarCode int not null, Discription varchar(255));

drop table Prizy.Store;

select * from Prizy.Store;

INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store1', 1111, 'Coffee');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store1', 2222, 'Oil');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store1', 3333, 'Pastas');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store1', 4444, 'Tea');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store1', 5555, 'Chocolates');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store1', 6666, 'Milk');

INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store2', 1111, 'Coffee');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store2', 2222, 'Oil');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store2', 3333, 'Pastas');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store2', 4444, 'Tea');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store2', 5555, 'Chocolates');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store2', 6666, 'Milk');

INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store3', 1111, 'Coffee');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store3', 2222, 'Oil');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store3', 3333, 'Pastas');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store3', 4444, 'Tea');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store3', 5555, 'Chocolates');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store3', 6666, 'Milk');

INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store4', 1111, 'Coffee');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store4', 2222, 'Oil');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store4', 3333, 'Pastas');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store4', 4444, 'Tea');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store4', 5555, 'Chocolates');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store4', 6666, 'Milk');

INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store5', 1111, 'Coffee');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store5', 2222, 'Oil');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store5', 3333, 'Pastas');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store5', 4444, 'Tea');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store5', 5555, 'Chocolates');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store5', 6666, 'Milk');

INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store6', 1111, 'Coffee');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store6', 2222, 'Oil');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store6', 3333, 'Pastas');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store6', 4444, 'Tea');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store6', 5555, 'Chocolates');
INSERT INTO Prizy.Store (Store, BarCode, Discription)
VALUES ('Store6', 6666, 'Milk');


create table Prizy.ProductsLoader (reqid INT AUTO_INCREMENT PRIMARY KEY, Store varchar(10), BarCode int not null, price double not null, Notes varchar(255));


