create table account (
                         account_no varchar(255) not null,
                         amount decimal(19,2),
                         change_date varchar(255),
                         change_time varchar(255),
                         customer_no varchar(255),
                         status varchar(255),
                         primary key (account_no)
);

create table transaction_log (
                                 customer_no varchar(255) not null,
                                 sequence_no varchar(255) not null,
                                 tx_dt varchar(255) not null,
                                 guid varchar(255),
                                 input varchar(255),
                                 output varchar(255),
                                 status varchar(255),
                                 tx_time varchar(255),
                                 primary key (customer_no, sequence_no, tx_dt)
);