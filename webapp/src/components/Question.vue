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

      <b-row class="question current-question" v-if="currentQuestion && !showSolution">
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
          <Solution/>
        </b-col>
      </b-row>

      <b-row v-if="theresNoSolution" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">
          Não identificamos nenhum problema!
        </b-col>
      </b-row>
    </b-container>

    <b-row class="footer">
      <div id="container" class="answer-buttons">
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Sim'), gotoBottom()"
          :disabled="showSolution || theresNoSolution"
        >Sim</b-button>
        <ModalQuestion class="ml-5 mr-5"/>
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Não'), gotoBottom()"
          :disabled="showSolution || theresNoSolution"
        >Não</b-button>
      </div>
    </b-row>
  </div>
</template>

<script>
import StageService from "@/services/stage.service.js";
import ModalQuestion from "@/components/ModalQuestion";
import Solution from "@/components/Solution";

export default {
  components: {
    ModalQuestion,
    Solution
  },
  name: "Question",

  data: () => ({
    currentQuestion: null,
    questionList: [],
    chatHistory: [],
    showSolution: false,
    theresNoSolution: false,
    idStage: 1
  }),

  created() {
      StageService.getStageById(this.idStage).then(response => {
      let stage = response.data;
      this.questionList = stage.questions;
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
      if (this.quantityNegativeAnswers() === 2) {
        this.showSolution = true;
        this.nextStage();
        return;
      }
      if (!this.questionList.length
          && this.quantityNegativeAnswers() === 1) {
        this.showSolution = true;
        this.nextStage();
        return;
      }
      this.solutionNotIdentified()
      this.nextQuestion();
      this.gotoBottom();
    },
    solutionNotIdentified() {
      if (!this.questionList.length && this.quantityNegativeAnswers() === 0) {
        this.theresNoSolution = true;
        this.nextStage();
      }
    },
    quantityNegativeAnswers () {
      return this.chatHistory
                 .filter(question => question.response === "Não").length
    },
    gotoBottom(){
      this.$nextTick(() => {
        const element = this.$el.querySelector(".chat-box");
        element.scrollIntoView({behavior: "smooth", block: "end"})
      });
    },
    nextStage(){
      if(this.theresNoSolution===true || this.showSolution===true){
        this.idStage++;
        this.questionList = [];
        StageService.getStageById(this.idStage).then(response => {
          let stage = response.data;
          this.questionList = stage.questions;
          this.theresNoSolution = false;
          this.showSolution = false;
          this.nextQuestion();
        });
        console.log("OI AMIGUINHO, ESTAMOS NO ESTÁGIO " + this.idStage);
      }
    }
  }
};
</script>

<style lang="scss">
@import '@/assets/scss/config/variables.scss';
@media (min-width: 100px) {
  .chat {
    background-color: $secondary-color;
    position: fixed;
    width: 100%;
    height: 80%;
    overflow-y: auto;
    .chat-box {
      padding: 3rem 2rem;
      img {
        border-radius: 50%;
        width: 1.5rem;
      }
      .question {
        text-align: left;
        color: $question-text-color;
        font-family: "Lato, sans-serif",serif;
        font-size: 13pt;
      }
      .answer {
        text-align: right;
        color: $question-text-color;
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
      background-color: $secondary-color;

      #container {
        display: flex;
        justify-content: space-between;
        padding: 0.5rem 0.5rem 30px 0.5rem;

        .answer-btn {
          background-color: $primary-color;
          border-color: $primary-color;
        }
        .doubt-btn {
          background-color: $secondary-color;
          border-color: $primary-color;
          color: $primary-color;
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