<template>
  <div>
    <p>
      {{solutionDescription}}
      <a v-bind:href="solutionLink" target="_blank">Clique aqui</a>
    </p>
  </div>
</template>

<script>
import StageService from "@/services/stage.service";

export default {
  data: () => ({
    solutionScreen: "",
    solutionDescription: "",
    solutionLink: ""
  }),
  props: ["idStage"],
  created() {
    StageService.getStageById(this.$props.idStage).then(r => {
      const stage = r.data;
      this.solutionScreen = stage.solution;
      this.splitSolution();
    });
  },
  methods: {
    splitSolution() {
      let splittedSolution = this.solutionScreen.split(" ");
      this.solutionLink = splittedSolution[splittedSolution.length - 1];
      splittedSolution.forEach(element => {
        if (element === this.solutionLink) return;
        this.solutionDescription += element + " ";
      });
      console.log(this.solutionDescription);
    }
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
