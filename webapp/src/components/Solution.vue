<template>
  <div>
    <p>{{solutionScreen}}</p>
  </div>
</template>

<script>
import StageService from "@/services/stage.service";

export default {
  data: () => ({
    solutionScreen: "",
    idStage: 1
  }),
  created() {
    StageService.getStageById(this.idStage).then(r => {
      const stage = r.data;
      this.solutionScreen = stage.solution;
    });
  }
};
</script>

<style lang="scss">
@media (min-width: 100px) {
  p {
    text-align: left;
    font-family: "Lato, sans-serif";
    font-size: 13pt;
  }
}
</style>
