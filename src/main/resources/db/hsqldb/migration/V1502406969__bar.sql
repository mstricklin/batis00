
create sequence bar_seq as integer;

create table bar (
    id integer GENERATED BY DEFAULT AS SEQUENCE bar_seq PRIMARY KEY,
    s0 varchar(255)
);

