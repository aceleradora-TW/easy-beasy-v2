<template>
  <div>
    <div class="chat">
      <div v-if="questionList.length">
        <p class="question">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />Bem vindo a Easybeasy! A nossa plataforma irá realizar o diagnóstico da sua empresa a partir de perguntas, e respostas de “sim” ou “não”. Vamos começar!
        </p>
        <p class="question" v-for="question in chatHistory" v-bind:key="question.description">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          {{question.description}}
        </p>

        <div>
          <p class="answer">{{userResponse}}</p>
        </div>
      </div>
    </div>

    <div class="footer">
      <div class="answer-buttons">
        <b-button class="answer-btn" v-on:click="nextQuestion(), collectPositiveAnswer()">sim</b-button>
        <b-button class="answer-btn" v-on:click="nextQuestion(), collectNegativeAnswer()">nao</b-button>
      </div>
    </div>
    <div>
      <Solutions v-if="seen" id="showHide"/>
    </div>
  </div>
</template>

<script>
import questionService from "@/services/questions.service.js";
import Solutions  from "../modules/Solutions/Solutions";

export default {
  name: "Question",
  data: () => ({
    questionList: [],
    chatHistory: [],
    userResponse: null,
    negativeCount: null,
    seen: true
  }),

  components: {
    Solutions
  },

  created() { 
    questionService.getQuestions().then(list => {
      this.questionList = list.data;
      this.nextQuestion();
    });
  },
  methods: {
    nextQuestion() {
      this.chatHistory.push(this.questionList.shift())
    },
    collectPositiveAnswer() {
      this.userResponse = "Sim";
      this.makeDiagnostic("Sim");
    },
    collectNegativeAnswer() {
      this.userResponse = "Não";
      this.makeDiagnostic("Não");
      this.negativeCount++;

      if (this.negativeCount == 2) {
        return Solutions;
      }

    },
    makeDiagnostic: (resposta) => {
      console.log("texto aleatorio de teste  --->>" + resposta);
 /*     do {
        console.log("texto de user response dentro do do");
        this.userResponse = resposta;



      } while (this.negativeCount < 2);     //com dois nãos interrompe a área na hora e recebe a solução do estágio

      if (this.negativeCount > 0) {            //chegar ao fim do estágio com 1 não, recebe a solução do estágio
        return solutions;
      }
  */  }

  }
};
</script>

<style lang="scss">
@media (min-width: 100px) {
  .chat {
    background-color: #ffffff;
    position: fixed;
    width: 100%;
    overflow-y: hidden;
    padding: 2rem;
    .question {
      text-align: left;
      color: #b1b1b1;
      img {
        border-radius: 50%;
        width: 1.5rem;
      }
    }
    .answer {
      text-align: right;
      color: #636363;
    }
  }

  .footer {
    position: fixed;
    bottom: 0rem;
    width: 100%;
    background-color: #ffffff;
    .answer-buttons {
      display: flex;
      justify-content: space-between;
      max-width: 200px;
      margin: 0 auto;
      padding: 0.5rem;
      bottom: 10px;
      .answer-btn {
        background-color: #2fc0d5;
        border-color: #2fc0d5;
      }
    }
  }
}
</style>