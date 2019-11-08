<template>
  <div>
    <p>{{solutionScreen}}</p>
  </div>
</template>

<script>
import Solution from "@/services/stage.service";

export default {
  data: () => ({
    solutionScreen: "",
    idStage: 1
  }),
  created() {
    Solution.getStageById(this.idStage).then(r => {
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
    color: #111111;
    font-family: "Lato, sans-serif";
    font-size: 13pt;
  }
}
</style>
