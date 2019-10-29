package com.thoughtworks.aceleradora.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.thoughtworks.aceleradora.domain.Question;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class QuestionRepository {
    private static ArrayList<Question> questions = new ArrayList<>(Arrays.asList(
        new Question("Você tem uma organização de tempo e tarefas?"),
        new Question("Você geralmente esquece de coisas que precisam ser feitas?"),
        new Question("Você organiza a semana em tarefas e metas a serem cumpridas?"),
        new Question("Você utiliza alguma ferramenta ou estratégia para organizar a sua semana?"),
        new Question("Você tem um controle do dinheiro que entra e sai da empresa?"),
        new Question("Você tem controle sobre das datas dos pagamentos e recebimentos?"),
        new Question("Você sabe quanto dinheiro gasto por mês?"),
        new Question("Você sabe qual é o faturamento mensal da empresa?"),
        new Question("Você sabe quais são as despesas e os custos da empresa?"),
        new Question("Você sabe as diferenças entre custos e despesas? "),
        new Question("Você sabe quais são os custos fixos e variáveis da sua empresa?"),
        new Question("Você sabe quanto custa fazer o seu produto/serviço?"),
        new Question("Você sabe qual é o custo por mercadoria/serviço vendido?"),
        new Question("Você entende que o custo de cada produto pode variar de acordo com a quantidade produzida?"),
        new Question("Você acredita que o preço do seu produto/serviço está de acordo com o mercado e os custos da empresa?"),
        new Question("Você calculou o preço do seu produto de acordo com os custos e a margem de contribuição?"),
        new Question("Você tem conhecimento sobre o público que consome o seu produto?"),
        new Question("Você conhece as principais características dos seus clientes?"),
        new Question("Você compreende as dores e as necessidades do seu cliente, de acordo com as características dele?"),
        new Question("Você utilizou algum método ou ferramenta para entender melhor o seu cliente?"),
        new Question("Você sabe qual é o tamanho do seu mercado?"),
        new Question("Você reconhece o número de clientes do seu mercado?"),
        new Question("Você tem a noção da quantidade de possíveis clientes que o seu público alvo representa no mercado?"),
        new Question("Você sabe por que o cliente compra o seu produto e não o da concorrência?"),
        new Question("Você sabe se o seu cliente recomendaria o seu produto para alguém? E por que?")));

    public List<Question> getAllQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        if(StringUtils.isEmpty(question.getDescription())) {
            throw new IllegalArgumentException("The question description cannot be null.");
        }
        questions.add(question);
    }

    public Question deleteQuestion(int index) {
        return questions.remove(index);
    }
}
