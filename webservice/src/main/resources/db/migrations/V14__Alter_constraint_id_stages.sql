ALTER TABLE questions DROP CONSTRAINT question_fk_id_stage_fkey;
ALTER TABLE questions ADD CONSTRAINT id_stage FOREIGN KEY (id_stage) REFERENCES stages(id);