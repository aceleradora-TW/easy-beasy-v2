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

insert into stage(solution, hint, number)
values('Podemos melhorar alguns pontos na sua gestão de tempo e tarefas. A solução consistirá em como organizar suas atividades, definir prazos e metas, além da indicação de algumas ferramentas que poderão complementar a sua rotina. Confira no link a baixo a solução para a sua pendência:

https://medium.com/@easybeasybr/gestão-de-tempo-e-tarefas-p1-12a51de24f75', 'Pense no seu dia a dia, se você sabe qual o próximo passo que deve ser tomado, se tem esclarecido quais e quando suas tarefas devem ser feitas.', 1),

('Além de fechar o mês no azul é importante saber por quê e como isso aconteceu, caso contrário você poderá se deparar com surpresas e até acabar tendo prejuízo por falta de organização. Para resolver isso vamos te ensinar como fazer um controle fácil de tudo que entra e sai do caixa do seu negócio. Confira no link a baixo a solução para a sua pendência:

https://medium.com/@easybeasybr/controle-financeiro-b%C3%A1sico-p2-b1903b79a182', 'Tendo em mente o dinheiro que circula na sua empresa, é importante que saiba quanto você recebe, quanto você gasta e quanto é necessário para se manter.', 2),

('Custos e despesas são coisas diferentes na hora de gerenciarmos as contas do negócio. Podemos balancear estes dois conceitos e atingir resultados melhores se pensarmos estrategicamente. Confira no link a baixo a solução para a sua pendência:

https://medium.com/@easybeasybr/custos-e-despesas-fa1-10e123894cf7', 'Será que você calcula tudo da melhor maneira? Agora estamos focando nas suas despesas, quanto você gasta para se manter aberto e quanto precisa para a produção do seu serviço ou produto.', 3),

('Entender que a quantidade de produção de serviços e produtos impacta diretamente no custo de cada serviço é fundamental para solucionar problemas financeiros. Confira no link a baixo a solução para a sua pendência:

https://medium.com/@easybeasybr/custo-do-meu-produto-fa2-75d576cb3767', 'Nesta etapa avalie tudo que é preciso para produzir o seu serviço ou produto, desde os materiais até a mão de obra e se você sabe ao certo os preços de cada um.', 4),

('O preço é um fator crucial para o sucesso de uma empresa, que caso seja calculado de maneira errada poderá ser fatal para o negócio. Aprenda como calcular de forma simples e melhore o seu desempenho financeiro. Confira no link a baixo a solução para a sua pendência:

https://medium.com/@easybeasybr/pre%C3%A7o-final-e-lucro-fa3-582f17069d28', 'Quando o assunto é preço, é necessária muita atenção. Reflita se você organiza seus custos fixos, variáveis e também o seu lucro.', 5),

('Para atingirmos melhores resultados é fundamental conhecer bem o seu cliente, por isso iremos aprender um pouco mais sobre quem consome do seu negócio. Iremos criar personas para isso. Não se preocupe se você ainda não souber o que é, irei lhe explicar tanto o que é, quanto como fazer.
Confira no link a baixo a solução para a sua pendência:

https://medium.com/@easybeasybr/personas-ma1-5d58dbaa02c8', 'Estamos falando do seu cliente, aquele que consome o seu serviço ou produto. Pense no seu consumidor, se sabe suas dores, seus problemas para desta maneira oferecer a melhor solução para ele.', 6),

('Ter conhecimento avançado sobre o mercado no qual seu negócio atua é muito importante e irá te preparar para encarar o mundo competitivo. Nessa solução irei te ensinar como fazer uma pesquisa e também quais pontos são interessantes ter na ponta da língua.
Confira no link a baixo a solução para a sua pendência:

 https://medium.com/@easybeasybr/pesquisando-o-mercado-ma2-3e377f5c603a', 'Responda as perguntas pensando no seu mercado, se você conhece bem seus concorrentes, quantos clientes em potencial você tem e qual tamanho da parcela de mercado que você pode impactar.', 7),

 ('O primeiro passo para melhorias é conhecer as razões pelas quais as pessoas aprovam ou reprovam o seu produto/serviço. Se você ainda não tem isso registrado, poderá estar perdendo oportunidades importantes. Vou te ensinar como fazer este registro e também disponibilizar um meio fácil de acompanhar todo o seu progresso.
Confira no link a baixo a solução para a sua pendência:

https://medium.com/@easybeasybr/pontuando-meu-produto-servi%C3%A7o-ma3-2a453a1065d0', 'Tenha em mente o seu cliente, se você sabe o quanto ele está satisfeito. Reflita sobre o que diferencia você da concorrência, o que faz seus consumidores comprarem de você.', 8);