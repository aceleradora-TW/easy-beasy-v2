CREATE TABLE question (
    id serial primary key,
    description VARCHAR,
    fk_id_stage bigint not null,
    FOREIGN KEY (fk_id_stage) REFERENCES stage(id)
);

