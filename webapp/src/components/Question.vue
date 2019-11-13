<template>
  <div class="chat">
    <ModalNps/>
    <ModalData :callBack="callBack" />
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
      <div
        class="question question-history"
        v-for="answeredQuestion in chatHistory"
        v-bind:key="answeredQuestion.description">
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
        <b-col cols="9">{{title}}</b-col>
      </b-row>

      <b-row v-if="showSolution" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">
          <Solution />
        </b-col>
      </b-row>

      <b-row v-if="theresNoSolution" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">Não identificamos nenhum problema!</b-col>
      </b-row>
    </b-container>

    <b-row class="footer">
      <div id="container" class="answer-buttons">
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Sim'), gotoBottom()"
          :disabled="showSolution || theresNoSolution || isTypewriterRunning"
        >Sim</b-button>
        <ModalQuestion class="ml-5 mr-5" :disableButtonNotUnderstand="disableButtonNotUnderstand" />
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Não'), gotoBottom()"
          :disabled="showSolution || theresNoSolution || isTypewriterRunning"
        >Não</b-button>
      </div>
    </b-row>
  </div>
</template>

<script>
import StageService from "@/services/stage.service.js";
import ModalQuestion from "@/components/ModalQuestion";
import Solution from "@/components/Solution";
import ModalNps from "@/components/ModalNps";
import ModalData from "@/components/ModalData";

export default {
  components: {
    ModalQuestion,
    Solution,
    ModalNps,
    ModalData
  },
  name: "Question",

  data: () => ({
    currentQuestion: null,
    questionList: [],
    chatHistory: [],
    showSolution: false,
    theresNoSolution: false,
    idStage: 1,
    isTypewriterRunning: false,
    callBack: () => {},
    disableButtonNotUnderstand: false,
    title: "",
    titleToWrite:""
  }),

  created() {
      StageService.getStageById(this.idStage).then(response => {
      let stage = response.data;
      this.questionList = stage.questions;
      this.nextQuestion();
    })
    .catch((error) => {
      console.log(error.response.data)
    });
  },
  methods: {
   typeWrite() {
      this.clearTypewriter();
      this.isTypewriterRunning = true;
      new Promise((resolve, reject) => {
        [...this.currentQuestion.description].forEach((char, index) => {
        setTimeout(() => {
          this.title += char;
          if(this.title === this.currentQuestion.description) resolve();
          }, 20 * index);
        });
      }).then(() => {
        this.isTypewriterRunning = false;
      });
    },
    clearTypewriter() {
      this.title = "";
    },
    nextQuestion() {
      this.currentQuestion = this.questionList.shift();
      this.titleToWrite = this.currentQuestion;
      this.typeWrite();
    },
    collectAnswer(answer) {
      this.chatHistory.push({
        description: this.currentQuestion.description,
        response: answer
      });
      this.shouldShowSolution();
    },
    showSolutionMessage() {
      this.showSolution = true;
    },
    showSolutionNotIndefiedMessage() {
      this.theresNoSolution = true;
    },
    shouldShowSolution() {
      if (this.quantityNegativeAnswers() === 2) {
        this.disableButtonNotUnderstand = true;
        this.showModalData();
        this.callBack = this.showSolutionMessage;
        this.showNps();
        this.showSolution = true;
        this.nextStage();
      }
      if (!this.questionList.length && this.quantityNegativeAnswers() === 1) {
        this.disableButtonNotUnderstand = true;
        this.showModalData();
        this.callBack = this.showSolutionMessage;
        this.showNps();
        this.showSolution = true;
        this.nextStage();
      }
      this.solutionNotIdentified()
      this.nextQuestion();
    },
    solutionNotIdentified() {
      if (!this.questionList.length && this.quantityNegativeAnswers() == 0) {
        this.disableButtonNotUnderstand = true;
        this.showModalData();
        this.callBack = this.showSolutionNotIndefiedMessage;
        this.showNps()
        this.theresNoSolution = true;
        this.nextStage();
      }
    },
    quantityNegativeAnswers() {
      return this.chatHistory
              .filter(question => question.response === "Não").length
    },
    gotoBottom() {
      this.$nextTick(() => {
        const element = this.$el.querySelector(".chat-box");
        element.scrollIntoView({behavior: "smooth", block: "end"})
      });
    },
    showNps() {
      this.$bvModal.show('modalNps')
    },
    showModalData() {
      this.$bvModal.show("modalData");
    },
    nextStage(){
      if(this.theresNoSolution===true || this.showSolution===true){
        this.idStage++;
        this.questionList = [];
        StageService.getStageById(this.idStage).then(response => {
          let stage = response.data;
          this.questionList = stage.questions;
          this.theresNoSolution = false;
          this.nextQuestion();

        })
        .catch((error) => {
          console.log(error.response.data);
        });
      }
    }
  }
};
</script>

<style lang="scss">
@import "@/assets/scss/config/variables.scss";
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
        font-family: "Lato, sans-serif", serif;
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
        .modal-question-btn {
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