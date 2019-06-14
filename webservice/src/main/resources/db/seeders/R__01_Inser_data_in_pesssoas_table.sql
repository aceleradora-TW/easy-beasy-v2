--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from pessoas;

--Reseta gerador de ids para 1
alter SEQUENCE pessoas_id_seq RESTART with 1;


insert
  into pessoas
  (nome,sobrenome)  
  values
  ('Jean', 'Sarlôn'),
  ('Juliane', 'Martins'),
  ('Pedro', 'Cabral'),
  ('Renato', 'Portalupi');
