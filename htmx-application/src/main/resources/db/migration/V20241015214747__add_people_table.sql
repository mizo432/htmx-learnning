create table people
(
    id        numeric(19, 0) primary key,
    email     varchar(128),
    phone     varchar(15)  not null,
    initials  varchar(6)   not null,
    user_code varchar(10)  not null,
    password  varchar(128) not null,
    is_hidden bit          not null,
    name      varchar(128) not null

)
