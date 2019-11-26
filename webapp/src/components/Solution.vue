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
  }),
  props: ['idStage'],
  created() {
    StageService.getStageById(this.$props.idStage).then(r => {
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
    font-size: 13pt;
  }
}
</style>
