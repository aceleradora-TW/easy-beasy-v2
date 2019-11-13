--Remove todos os dados das tabelas para evitar duplicacoes de dados de teste
delete from question;
delete from stage;

--Reseta gerador de ids para 1
alter SEQUENCE question_id_seq RESTART with 1;
alter SEQUENCE stage_id_seq RESTART with 1;
alter SEQUENCE fk_id_stage RESTART with 1;

insert into question(description, fk_id_stage)
values('Você tem uma organização de tempo e tarefas?', 1),
('Você geralmente lembra de coisas que precisam ser feitas?', 1),
('Você organiza a semana em tarefas e metas a serem cumpridas?', 1),
('Você utiliza alguma ferramenta ou estratégia para organizar a sua semana?', 1),
('Você tem um controle do dinheiro que entra e sai da empresa?', 2),
('Você tem controle sobre das datas dos pagamentos e recebimentos?', 2),
('Você sabe quanto dinheiro é gasto por mês?', 2),
('Você sabe qual é o faturamento mensal da empresa?', 2),
('Você sabe quais são as despesas e os custos da empresa?', 3),
('Você sabe as diferenças entre custos e despesas? ', 3),
('Você sabe quais são os custos fixos e variáveis da sua empresa?', 3),
('Você sabe quanto custa fazer o seu produto/serviço?', 4),
('Você sabe qual é o custo por mercadoria vendida?', 4),
('Você entende que o custo de cada produto pode variar de acordo com a quantidade produzida?', 4),
('Você acredita que o preço do seu produto/serviço está de acordo com o mercado e os custos da empresa?', 5),
('Você calculou o preço do seu produto de acordo com os custos e a margem de contribuição?', 5),
('Você tem conhecimento sobre o público que consome o seu produto?', 6),
('Você conhece as principais características dos seus clientes?', 6),
('Você compreende as dores e as necessidades do seu cliente, de acordo com as características dele?', 6),
('Você utilizou algum método ou ferramenta para entender melhor o seu cliente?', 6),
('Você sabe qual é o tamanho do seu mercado?', 7),
('Você reconhece o número de clientes do seu mercado?', 7),
('Você tem a noção da quantidade de possíveis clientes que o seu público alvo representa no mercado?', 7),
('Você sabe por que o cliente compra o seu produto e não o da concorrência?', 8),
('Você sabe se o seu cliente recomendaria o seu produto para alguém? E por que?', 8);

