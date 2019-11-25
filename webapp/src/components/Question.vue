<template>
  <div class="chat">
    <ModalData :callBack="callBack" />
    <ModalNps :callBack="callBack" />
    <b-container class="chat-box">
      <b-row align-h="start" class="mb-4">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">
          Olá, somos a Easybeasy! A nossa plataforma irá realizar o diagnóstico
          da sua empresa a partir de perguntas e respostas de “sim” ou “não”.
          Vamos começar!
        </b-col>
      </b-row>
      <div
        class="question-history"
        v-for="answeredQuestion in chatHistory"
        v-bind:key="answeredQuestion.description"
      >
        <b-row>
          <b-col cols="auto">
            <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          </b-col>
          <b-col cols="9" class="question mb-3">{{
            answeredQuestion.description
          }}</b-col>
        </b-row>

        <b-row align-h="end">
          <b-col cols="2" class="answer mb-3">{{
            answeredQuestion.response
          }}</b-col>
        </b-row>
      </div>
      <b-row class="current-question" v-if="currentQuestion && !showSolution">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col class="question" cols="9">{{ typewritingQuestion }}</b-col>
      </b-row>

      <b-row v-if="thankData" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">{{ feedbackData }}</b-col>
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
        <b-col cols="9" class="question">{{ solutionNotFound }}</b-col>
      </b-row>

      <b-row v-if="showSolution" class="mb-3">
        <b-col cols="auto" class="mb-3">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-button
          v-on:click="showNps"
          cols="9"
          class="showNps question"
          >Por favor, 
          <strong>clique aqui</strong> e nos ajude a melhorar!</b-button
        >
      </b-row>

      <b-row v-if="thankNps" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">{{ feedbackNps }}</b-col>
      </b-row>

    </b-container>

    <b-row class="footer">
      <div id="container" class="answer-buttons">
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Sim'), gotoBottom()"
          :disabled="showSolution || theresNoSolution || isTypewriterRunning"
          >Sim</b-button
        >
        <ModalQuestion
          class="ml-5 mr-5"
          :disableButtonNotUnderstand="disableButtonNotUnderstand"
        />
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Não'), gotoBottom()"
          :disabled="showSolution || theresNoSolution || isTypewriterRunning"
          >Não</b-button
        >
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
    solutionNotFound: "Não identificamos nenhum problema!",
    idStage: 1,
    isTypewriterRunning: false,
    callBack: () => {},
    disableButtonNotUnderstand: false,
    typewritingQuestion: "",
    feedbackNps: "Obrigada pelo seu feedback!",
    feedbackData: "Obrigada! Agora podemos prosseguir.",
    thankNps: false,
    thankData: false
  }),

  created() {
    StageService.getStageById(this.idStage)
      .then(response => {
        let stage = response.data;
        this.questionList = stage.questions;
        this.nextQuestion();
      })
      .catch(error => {});
  },
  methods: {
    typeWrite() {
      this.clearTypewriter();
      this.isTypewriterRunning = true;
      new Promise((resolve, reject) => {
        [...this.currentQuestion.description].forEach((char, index) => {
          setTimeout(() => {
            this.typewritingQuestion += char;
            if (this.typewritingQuestion === this.currentQuestion.description)
              resolve();
          }, 40 * index);
        });
      }).then(() => {
        this.isTypewriterRunning = false;
      });
    },
    clearTypewriter() {
      this.typewritingQuestion = "";
    },
    nextQuestion() {
      this.currentQuestion = this.questionList.shift();
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
      this.showThanksData();
    },
    showNoSolutionIndefiedMessage() {
      this.theresNoSolution = true;
      this.showThanksData();
    },
    shouldShowSolution() {
      if (this.quantityNegativeAnswers() === 2) {
        this.disableButtonNotUnderstand = true;
        this.showModalData();
        this.callBack = this.showSolutionMessage;
        this.nextStage();
      }
      if (!this.questionList.length && this.quantityNegativeAnswers() === 1) {
        this.disableButtonNotUnderstand = true;
        this.showModalData();
        this.callBack = this.showSolutionMessage;
        this.showSolution = true;
        this.nextStage();
      }
      this.solutionNotIdentified();
      this.nextQuestion();
    },
    solutionNotIdentified() {
      if (!this.questionList.length && this.quantityNegativeAnswers() == 0) {
        this.disableButtonNotUnderstand = true;
        this.showModalData();
        this.callBack = this.showNoSolutionIndefiedMessage;
        this.theresNoSolution = true;
        this.nextStage();
      }
    },
    showThanksData(){
      this.thankData = true;
    },
    quantityNegativeAnswers() {
      return this.chatHistory.filter(question => question.response === "Não")
        .length;
    },
    gotoBottom() {
      this.$nextTick(() => {
        const element = this.$el.querySelector(".chat-box");
        element.scrollIntoView({ behavior: "smooth", block: "end" });
      });
    },
    showNps() {
      this.$bvModal.show("modalNps");
      this.callBack = this.showThanksNps;
    },
    showThanksNps() {
      this.thankNps = true;
    },
    showModalData() {
      this.$bvModal.show("modalData");
    },
    nextStage() {
      if (this.theresNoSolution === true || this.showSolution === true) {
        this.idStage++;
        this.questionList = [];
        StageService.getStageById(this.idStage)
          .then(response => {
            let stage = response.data;
            this.questionList = stage.questions;
            this.theresNoSolution = false;
            this.nextQuestion();
          })
          .catch(error => {
            console.log(error);
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
    .showNps {
      background-color: #ffffff;
      border-color: #ffffff;
      color: rgb(54, 54, 218);
    }
    .chat-box {
      padding: 3rem 2rem;

      img {
        border-radius: 50%;
        width: 1.5rem;
      }
      .question {
        position: relative;
        background: $primary-color;
        border-radius: 0.4em;
        padding: 1em;
        color: #fff;
        text-align: start;
      }
      .question:after {
        content: "";
        position: absolute;
        left: 0;
        top: 50%;
        width: 0;
        height: 0;
        border: 12px solid transparent;
        border-right-color: $primary-color;
        border-left: 0;
        border-top: 0;
        margin-top: -6px;
        margin-left: -12px;
      }
      .feedback {
        text-align: left;
        font-size: 13pt;
      }
      .answer {
        position: relative;
        background: #e2e2e2;
        border-radius: 0.4em;
        color: #0e0606;
      }
      .answer:after {
        position: absolute;
        right: 0;
        top: 50%;
        width: 0;
        height: 0;
        border: 12px solid transparent;
        border-left-color: #e2e2e2;
        border-right: 0;
        border-top: 0;
        margin-top: -6px;
        margin-right: -12px;
      }
      .npsClick {
        text-decoration: underline;
        font-weight: bold;
      }
      .npsClick:hover {
        text-decoration: underline;
        cursor: pointer;
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
