ALTER TABLE stages ADD id_area bigint;
ALTER TABLE stages ADD FOREIGN KEY (id_area) REFERENCES areas (id);