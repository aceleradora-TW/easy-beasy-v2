ALTER TABLE stages ADD id_area bigint not null;
ALTER TABLE stages ADD FOREIGN KEY (id_area) REFERENCES areas (id);