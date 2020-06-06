drop table if exists transaction;
create table transaction (
  id identity auto_increment not null,
  transaction_date date not null,
  requestor varchar(50),
  location varchar(30),
  status varchar(20),
  transaction_code varchar(20),
  description clob,
  last_update TIMESTAMP AS CURRENT_TIMESTAMP,
  primary key (id)
);

