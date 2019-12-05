<template>
  <div>
    <b-table striped hover :items="questionList"></b-table>
  </div>
</template>

<script>
import QuestionService from "@/services/question.service.js";

export default {
    components: {},
    name: "ViewQuestions",

  data: () => ({
    questionList: []
  }),
  created() {
    QuestionService.getQuestions()
      .then(response => {
        this.questionList = response.data;
        console.log(this.questionList);
      })
      .catch(error => {});
  }
};
</script>
