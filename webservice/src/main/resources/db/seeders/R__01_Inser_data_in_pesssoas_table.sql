--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from pessoas;

--Reseta gerador de ids para 1
alter SEQUENCE pessoas_id_seq RESTART with 1;


insert
  into pessoas(id, nome, sobrenome)  
  values
  (1, 'Jean',    'Sarlôn'),
  (2, 'Juliane', 'Martins'),
  (3, 'Pedro',   'Cabral'),
  (4, 'Renato',  'Portalupi');
