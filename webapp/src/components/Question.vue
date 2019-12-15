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
        <b-row v-if="answeredQuestion.description">
          <b-col cols="auto">
            <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          </b-col>
          <b-col cols="9" class="question mb-3">{{ answeredQuestion.description }}</b-col>
        </b-row>

        <b-row v-if="answeredQuestion.response" align-h="end">
          <b-col cols="2" class="answer mb-3">{{ answeredQuestion.response }}</b-col>
        </b-row>

        <b-row v-if="answeredQuestion.thankData" class="mb-3">
          <b-col cols="auto">
            <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          </b-col>
          <b-col cols="9" class="question">{{ answeredQuestion.thankData }}</b-col>
        </b-row>

        <b-row v-if="answeredQuestion.hasSolution" class="mb-3">
          <b-col cols="auto">
            <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          </b-col>
          <b-col cols="9" class="question">
            <Solution v-bind:idStage="idStage" />
          </b-col>
        </b-row>

        <b-row v-if="answeredQuestion.thankNps" class="mb-3">
          <b-col cols="auto">
            <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          </b-col>
          <b-col cols="9" class="question">{{ answeredQuestion.thankNps }}</b-col>
        </b-row>

        <b-row v-if="answeredQuestion.showNps" class="mb-3">
          <b-col cols="auto" class="mb-3">
            <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
          </b-col>
          <b-button :disabled="npsDisabled" v-on:click="showNps" cols="9" class="showNps">
            Por favor,
            <strong>clique aqui</strong> e nos ajude a
            melhorar!
          </b-button>
        </b-row>
      </div>

      <b-row v-if="isThereNextQuestion" class="current-question">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col class="question" cols="9">{{ typewritingQuestion }}</b-col>
      </b-row>

      <b-row v-if="endDiagnosis" class="mb-3">
        <b-col cols="auto">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />
        </b-col>
        <b-col cols="9" class="question">{{ solutionNotFound }}</b-col>
      </b-row>
    </b-container>

    <b-row class="footer">
      <div id="container" class="answer-buttons">
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Sim')"
          :disabled="theresNoSolution || isTypewriterRunning"
        >Sim</b-button>
        <ModalQuestion class="ml-5 mr-5" :disableButtonNotUnderstand="disableButtonNotUnderstand" />
        <b-button
          class="answer-btn"
          v-on:click="collectAnswer('Não')"
          :disabled="theresNoSolution || isTypewriterRunning"
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
    theresNoSolution: false,
    getNextStage: false,
    solutionNotFound: "Não identificamos nenhum problema!",
    idStage: 1,
    isTypewriterRunning: false,
    callBack: () => {},
    disableButtonNotUnderstand: false,
    typewritingQuestion: "",
    feedbackNps: "Obrigada pelo seu feedback!",
    feedbackData: "Obrigada! Agora podemos prosseguir.",
    continueMessage:
      "Sabemos que essa solução pode não ser o suficiente, deseja continuar?",
    isThereNextQuestion: false,
    endDiagnosis: false,
    speedTyping: 50,
    npsDisabled: false,
    quantityNegativeAnswers: 0
  }),
  watch: {
    chatHistory: function() {
      this.gotoBottom();
    }
  },
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
    nextQuestion() {
      this.currentQuestion = this.questionList.shift();
      this.isThereNextQuestion = true;
      this.typeWrite();
    },
    typeWrite() {
      this.clearTypewriter();
      this.isTypewriterRunning = true;
      new Promise((resolve, reject) => {
        [...this.currentQuestion.description].forEach((char, index) => {
          setTimeout(() => {
            this.typewritingQuestion += char;
            if (this.typewritingQuestion === this.currentQuestion.description)
              resolve();
          }, this.speedTyping * index);
        });
      }).then(() => {
        this.isTypewriterRunning = false;
      });
    },
    clearTypewriter() {
      this.typewritingQuestion = "";
    },
    async collectAnswer(answer) {
      if (this.getNextStage) {
        this.chatHistory.push({
          response: answer
        });
        this.getNextStage = false;
        this.nextStage();
        return;
      }
      if (answer === "Não") {
        this.quantityNegativeAnswers++;
      }
      this.chatHistory.push({
        description: this.currentQuestion.description,
        response: answer
      });
      this.shouldShowSolution();
    },
    showSolutionMessage() {
      this.chatHistory.push({
        hasSolution: true
      });
      this.questionList = [];
      this.npsButton();
      this.getNextStage = true;
      this.nextStageMessage();
    },
    nextStageMessage() {
      this.chatHistory.push({
        description: this.continueMessage
      });
    },
    npsButton() {
      this.chatHistory.push({
        showNps: true
      });
    },
    showThanksData() {
      this.chatHistory.push({
        thankData: this.feedbackData
      });
    },
    showThanksNps() {
      this.chatHistory.push({
        thankNps: this.feedbackNps
      });
    },
    shouldShowSolution() {
      if (this.quantityNegativeAnswers === 2) {
        debugger;
        this.returnSolution();
      }
      if (!this.questionList.length && this.quantityNegativeAnswers === 1) {
        this.returnSolution();
      }
      this.solutionNotIdentified();
      if (this.questionList.length) {
        this.nextQuestion();
      }
      return null;
    },
    returnSolution() {
      this.disableButtonNotUnderstand = true;
      if (!this.dataDisabled) {
        this.showModalData();
        this.callBack = this.showSolutionMessage;
      } else {
        this.showSolutionMessage();
      }
      this.isThereNextQuestion = false;
      return true;
    },
    solutionNotIdentified() {
      if (!this.questionList.length && this.quantityNegativeAnswers == 0) {
        this.theresNoSolution = true;
        this.isThereNextQuestion = false;
        this.nextStage();
      }
    },
    gotoBottom() {
      this.$nextTick(() => {
        const element = this.$el.querySelector(".chat-box");
        element.scrollIntoView({ behavior: "smooth", block: "end" });
      });
    },
    showNps() {
      if (!this.npsDisabled) {
        this.$bvModal.show("modalNps");
        this.npsDisabled = true;
        this.callBack = this.showThanksNps;
      }
    },
    showModalData() {
      this.$bvModal.show("modalData");
      this.dataDisabled = true;
      this.callBack = this.showThanksData;
    },
    nextStage() {
      this.idStage++;
      this.questionList = [];
      this.quantityNegativeAnswers = 0;
      StageService.getStageById(this.idStage)
        .then(response => {
          let stage = response.data;
          this.questionList = stage.questions;
          this.theresNoSolution = false;
          this.nextQuestion();
        })
        .catch(error => {
          this.endDiagnosis = true;
          this.showModalData();
          this.npsButton();
        });
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
    .question {
      text-align: left;
      color: $question-text-color;
      font-family: $primary-font-family;
      font-size: 13pt;
    }
    .chat-box {
      padding: 3rem 2rem;

      img {
        border-radius: 50%;
        width: 1.5rem;
      }
      .showNps {
        position: relative;
        background: $primary-color;
        border-radius: 2em;
        border-color: $primary-color;
        padding: -0.2em 0.3em -0.2em 0.3em;
        color: #fff;
        font-size: 13pt;
        text-align: start;
      }
      .feedback {
        text-align: left;
        font-size: 13pt;
      }
      .answer {
        text-align: right;
        color: $primary-font-family;
        font-family: $primary-font-family;
        margin-bottom: 15px;
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
