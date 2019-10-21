<template>
  <div class="hello">
    <div class="hello" v-if="questionList.length">
      <h1>{{currentQuestion.description}}</h1>
      <div>
        <p>{{userResponse}}</p>
        <b-button v-on:click="nextQuestion(), collectAnswer(true)"> sim </b-button>
        <b-button v-on:click="nextQuestion(), collectAnswer(false)"> nao </b-button>
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
    noCount: null
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
    collectAnswer(verification){
      if (verification){
        this.userResponse = "Sim";
      } else {
        this.noCount++;
        this.userResponse = "Não";
      }
    }
  }
  
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
