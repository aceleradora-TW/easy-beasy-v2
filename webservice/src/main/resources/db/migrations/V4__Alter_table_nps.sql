ALTER TABLE nps ADD COLUMN id_enterprising bigint,
ADD CONSTRAINT fk_enterprising FOREIGN KEY (id_enterprising) REFERENCES enterprising (id);