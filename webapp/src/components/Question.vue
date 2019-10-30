<template>
  <div>
    <div class="chat">
      <div>
        <p class="question welcome-question">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />Bem vindo a Easybeasy! A nossa plataforma irá realizar o diagnóstico da sua empresa a partir de perguntas, e respostas de “sim” ou “não”. Vamos começar!
        </p>
        <div class="question question-history" v-for="answeredQuestion in chatHistory" v-bind:key="answeredQuestion.description">
          <p> <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" /> {{answeredQuestion.description}}</p>
          <p class="answer">{{answeredQuestion.response}}</p>
        </div>
        <div class="question current-question" v-if="currentQuestion">
          <p> <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" /> {{currentQuestion.description}}</p>
        </div>
      </div>
    </div>

    <div class="footer">
      <div class="answer-buttons">
        <b-button class="answer-btn" v-on:click="collectAnswer('Sim')" :disabled='!currentQuestion'>Sim</b-button>
        <b-button class="answer-btn" v-on:click="collectAnswer('Não')" :disabled='!currentQuestion'>Não</b-button>
      </div>
    </div>
  </div>
</template>

<script>
import questionService from "@/services/questions.service.js";

export default {
  name: "Question",
  data: () => ({
    currentQuestion: null,
    questionList: [],
    chatHistory: [],
  }),

  created() {
    questionService.getQuestions().then(list => {
      this.questionList = list.data;
      this.nextQuestion();
    });
  },
  methods: {
    nextQuestion() {
      this.currentQuestion = this.questionList.shift();
    },
    collectAnswer(answer) {
      this.chatHistory.push({
        description: this.currentQuestion.description,
        response: answer
      });

      this.nextQuestion();
    }
  }
  
};
</script>

<style lang="scss">
@media (min-width: 100px) {
  .chat {
    background-color: #ffffff;
    position: fixed;
    width: 100%;
    height: 100%;
    overflow-y: auto;
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
