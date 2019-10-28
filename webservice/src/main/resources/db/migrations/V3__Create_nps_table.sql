CREATE TABLE nps (
  id serial primary key,
  note varchar(255),
  description varchar(255),
  id_enterpreneur bigint not null,
  FOREIGN KEY (id_enterpreneur) REFERENCES enterpreneur(id)
);

