<template>
  <div class="hello">
    <div class="hello" v-if="questionList.length">
      <p>Estamos aqui</p>
      <h1>{{currentQuestion.description}}</h1>
      <div>
        <b-button @click="nextQuestion"> sim </b-button>
        <b-button @click="nextQuestion"> nao </b-button>
        <p>{{userResponse}}</p>
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
    userResponse: false,
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
