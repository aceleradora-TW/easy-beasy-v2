<template>
  <div>
    <div class="chat">
      <div>
        <p class="question">
          <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" />Bem vindo a Easybeasy! A nossa plataforma irá realizar o diagnóstico da sua empresa a partir de perguntas, e respostas de “sim” ou “não”. Vamos começar!
        </p>
        <div class="question" v-for="question in chatHistory" v-bind:key="question.description">
          <p> <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo" /> {{question.description}}</p>
          <p class="answer">{{question.response}}</p>
        </div>
      </div>
    </div>

    <div class="footer">
      <div class="answer-buttons">
        <b-button class="answer-btn" v-on:click="collectPositiveAnswer()">Sim</b-button>
        <ModalNaoEntendi/>
        <b-button class="answer-btn" v-on:click="collectNegativeAnswer()">Não</b-button>
      </div>
    </div>
  </div>
</template>

<script>
import questionService from "@/services/questions.service.js";
import ModalNaoEntendi from "@/components/ModalNaoEntendi";


export default {
  components: {
    ModalNaoEntendi,

  },
  name: "Question",

  data: () => ({
    questionList: [],
    chatHistory: [],
    userResponseHistory: [],
    negativeCount: null,
    index: null
  }),

  created() {
    questionService.getQuestions().then(list => {
      this.questionList = list.data;
      this.nextQuestion();
      this.index = 0;
    });
  },
  methods: {
    nextQuestion() {
      this.chatHistory.push({
        response: "",
        description: this.questionList.shift().description
      });
    },
    collectPositiveAnswer() {
      if(this.questionList.length!==0){
        this.chatHistory[this.index].response = "Sim";
        this.index++;
        this.nextQuestion();
      }

    },
    collectNegativeAnswer() {
      if(this.questionList.length!==0) {
        this.chatHistory[this.index].response = "Não";
        this.index++;
        this.nextQuestion();
        this.negativeCount++;
      }
    },
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
      .dontUnderstand-btn{
        background-color: #ffffff;
        border-color: #2fc0d5;
        color: #2fc0d5;

      }

    }
  }
}
</style>