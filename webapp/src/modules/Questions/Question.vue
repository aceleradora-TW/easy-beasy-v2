<template>
  <div class="hello">
    <div class="hello" v-if="questionList.length">
      <h1>{{currentQuestion.description}}</h1>
      <div>
        <p>{{userResponse}}</p>
        <b-button v-on:click="nextQuestion(), collectPositiveAnswer()"> sim </b-button>
        <b-button v-on:click="nextQuestion(), collectNegativeAnswer()"> nao </b-button>
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