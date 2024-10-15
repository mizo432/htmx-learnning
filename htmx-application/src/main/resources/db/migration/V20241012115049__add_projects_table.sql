create table projects(
    id numeric(19,0) primary key ,
    name varchar(255) not null ,
    description varchar(65535),
    last_updated_at timestamp not null
)
