<template>
  <div class="chat">
    <b-container class="chat-box">
      <b-row align-h="start" class="mb-4">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">
          Olá, somos a Easybeasy! A nossa plataforma irá realizar o diagnóstico da sua
          empresa a partir de perguntas e respostas de “sim” ou “não”. Vamos começar!
        </b-col>
      </b-row>
      <div class="question question-history" v-for="answeredQuestion in chatHistory" v-bind:key="answeredQuestion.description">
        <b-row>
          <b-col cols="auto">
            <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          </b-col>
          <b-col cols="9" class="question mb-3">{{answeredQuestion.description}}</b-col>
        </b-row>

        <b-row align-h="end">
          <b-col cols="2" class="answer mb-3">{{answeredQuestion.response}}</b-col>
        </b-row>
      </div>

      <b-row class="question current-question" v-if="!showSolution">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9">{{currentQuestion.description}}</b-col>
      </b-row>

      <b-row v-if="showSolution" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">
          <Solutions></Solutions>
        </b-col>
      </b-row>

      <b-row v-if="solutionNotIdentified()" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">
          Não identificamos problema!!!
        </b-col>
      </b-row>
    </b-container>

    <b-row class="footer">
      <div id="container" class="answer-buttons">
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Sim')"
          :disabled="showSolution || solutionNotIdentified()"
        >Sim</b-button>
        <ModalQuestion class="ml-5 mr-5"/>
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Não')"
          :disabled="showSolution || solutionNotIdentified()"
        >Não</b-button>
      </div>
    </b-row>
  </div>
</template>

<script>
import questionService from "@/services/questions.service.js";
import ModalQuestion from "@/components/ModalQuestion";
import Solutions from "./Solutions";

export default {
  components: {
    ModalQuestion,
    Solutions
  },
  name: "Question",

  data: () => ({
    currentQuestion: "",
    questionList: [],
    chatHistory: [],
    showSolution: false
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
      this.shouldShowSolution();
    },
    shouldShowSolution() {
      if (this.quantityNegativeAnswers() == 2) {
        this.showSolution = true;
        return;
      }
      if (!this.questionList.length
          && this.quantityNegativeAnswers() == 1) {
        this.showSolution = true;
        return;
      }

      this.nextQuestion();
      this.gotoBottom();
    },
    solutionNotIdentified() {
      if (!this.questionList.length && this.quantityNegativeAnswers() == 0) {
        return true;
      }
    },
    quantityNegativeAnswers () {
      return this.chatHistory
                 .filter(question => question.response === "Não").length
    },
    gotoBottom(){
      var element = document.querySelector("div.chat-box.container");element.scrollIntoView({behavior: "smooth", block: "end"});
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
    height: 86%;
    overflow-y: scroll;
    .chat-box {
      padding: 3rem 2rem;
      img {
        border-radius: 50%;
        width: 1.5rem;
      }
      .question {
        text-align: left;
        color: #151515;
        font-family: "Lato, sans-serif";
        font-size: 13pt;
      }
      .answer {
        text-align: right;
        color: #636363;
        margin-bottom: 15px;
      }
    }
    .footer {
      position: fixed;
      display: flex;
      align-items: center;
      justify-content: center;
      bottom: 0;
      width: 100%;
      background-color: #ffffff;

      #container {
        display: flex;
        justify-content: space-between;
        padding: 0.5rem 0.5rem 30px 0.5rem;

        .answer-btn {
          background-color: #2fc0d5;
          border-color: #2fc0d5;
        }
        .doubt-btn {
          background-color: #ffffff;
          border-color: #2fc0d5;
          color: #2fc0d5;
        }
        .answer-buttons {
          max-width: 200px;
          margin: 0 auto;
          padding: 0.5rem;
          bottom: 10px;
        }
      }
    }
  }
}
</style>