<template>
  <div class="chat">
    
    <div v-if="questionList.length">
      <p class="question"><img src="@/assets/images/easybeasy-logo.jpeg" alt="logo">Bem vindo a Easybeasy! A nossa plataforma irá realizar o diagnóstico da sua empresa a partir de perguntas, e respostas de “sim” ou “não”. Vamos começar!</p>
      <p class="question"><img src="@/assets/images/easybeasy-logo.jpeg" alt="logo">{{currentQuestion.description}}</p>
      <div>
        <p class="answer">{{userResponse}}</p>
        <div class="footer">
          <div class="answer-buttons">
            <b-button class="answer-btn" v-on:click="nextQuestion(), collectPositiveAnswer()"> sim </b-button>
            <b-button class="answer-btn" v-on:click="nextQuestion(), collectNegativeAnswer()"> nao </b-button>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import questionService from "@/services/questions.service.js";

export default {
  name: "Question",
  data: () => ({
    questionList: [],
    currentQuestion: null,
    userResponse: null,
    negativeCount: null
  }),

  created() { 
    questionService.getQuestions().then(list => {
      this.questionList = list.data;
      this.currentQuestion = this.questionList.shift();
    });
  },
  methods:{
    nextQuestion(){
      this.questionList.splice(0, 1);
      this.currentQuestion = this.questionList[0];
    },
    collectPositiveAnswer(){
        this.userResponse = "Sim";
    },
    collectNegativeAnswer(){
      this.userResponse = "Não";
      this.negativeCount++;
    }
  }
  
};
</script>