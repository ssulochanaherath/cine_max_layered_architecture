create table user(
                     userId varchar(20) primary key ,
                     fristName varchar(20) not null,
                     lastName varchar(20) not null,
                     userName varchar(20) not null,
                     password varchar(20) not null
);

create table customer(
                         customerId varchar(20) primary key,
                         name varchar(20) not null ,
                         address varchar(20) not null ,
                         tele varchar(20) not null,
                         userId varchar(20) not null ,
                         email varchar(50) not null,
                         constraint foreign key(userId) references user(userId) on delete cascade on update cascade
);

create  table movie (
                        movieId varchar(20) primary key ,
                        movieName varchar(20) not null,
                        movieGenre varchar(20) not null,
                        movieYear varchar(20) not null,
                        image longblob
);

create table showtime (
                          showtimeID varchar(20) PRIMARY KEY,
                          title varchar(20) not null,
                          date DATETIME not null
);

create table seats (
                       seatId varchar(20) PRIMARY KEY,
                       horizontal varchar(20) not null,
                       verticle varchar(20) not null,
                       seatNo varchar(20) not null,
                       status varchar(20) not null
);

create table tickets (
                         ticketId varchar(20) PRIMARY KEY,
                         customerId varchar(20) not null,
                         movieId varchar(20) not null,
                         seatId varchar(20) not null,
                         showtimeID varchar(20) not null,
                         price varchar(20) not null,
                         constraint foreign key(customerId) references customer(customerId) on delete cascade on update cascade,
                         constraint foreign key(movieId) references movie(movieId) on delete cascade on update cascade,
                         constraint foreign key(seatId) references seats(seatId) on delete cascade on update cascade,
                         constraint foreign key(showtimeID) references showtime(showtimeID) on delete cascade on update cascade
);

create table supplier(
                         supplierId varchar(20) PRIMARY KEY,
                         name varchar(20) not null,
                         address varchar(20) not null,
                         tele varchar(20) not null
);

create table item(
                     code varchar(35) primary key ,
                     description text not null ,
                     unit_price double not null,
                     qty_on_hand int not null
);

create table orders(
                       order_id varchar(35) primary key,
                       cus_id varchar(35) not null,
                       date date not null,
                       constraint foreign key (cus_id) references customer(customerId) on delete cascade on update cascade
);

create table order_detail(
                             order_id varchar(35) not null ,
                             item_code varchar(35) not null,
                             qty int not null,
                             unit_price double not null,
                             constraint foreign key (order_id) references orders(order_id) on delete  cascade on update cascade,
                             constraint foreign key (item_code) references item(code) on delete cascade on update cascade
);