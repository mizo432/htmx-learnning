create table sprints
(
    id              numeric(19, 0) primary key,
    start_date      date      not null,
    end_date        date      not null,
    description     varchar(65535),
    last_updated_at timestamp not null
)
