create table if not exists coin (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    code varchar(20),
    symbol varchar(20),
    rate CHARACTER,
    description CHARACTER,
    rate_float NUMERIC
);