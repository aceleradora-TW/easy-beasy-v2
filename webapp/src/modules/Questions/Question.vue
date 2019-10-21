<template>
  <div class="hello">
    <p>Estamos aqui</p>
    <h1>{{oneQuestion.description}}</h1>
  </div>
</template>

<script>
import questionService from "@/services/questions.service.js";

export default {
  name: "Question",
  data: () => ({
    questionList: [],
    oneQuestion: "",
  }),
  
  

  created() {
    questionService.getQuestions().then(list => {
      this.questionList = list.data;
      this.oneQuestion = this.questionList.shift();
    });
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
