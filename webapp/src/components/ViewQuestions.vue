<template>
  <div>
    <div v-for="question in stageList" v-bind:key="question.description">{{question.description}}</div>
  </div>
</template>

<script>
import StageService from "@/services/stage.service.js";

export default {
  data: () => ({
    stageList: []
  }),
  created() {
    StageService.getStages()
      .then(response => {
        console.log(response.data);
        let stages = response.data;
        this.stageList = stage.questions;
      })
      .catch(error => {});
  }
};
</script>