<template>
  <div>
    <p>{{solutionDescription}} <a v-bind:href=solutionLink target="_blank"> Clique aqui </a></p>
  </div>
</template>

<script>
import StageService from "@/services/stage.service";

export default {
  data: () => ({
    solutionScreen: "",
    solutionDescription: "",
    solutionLink: "",
    idStage: 1
  }),
  created() {
    StageService.getStageById(this.idStage).then(r => {
      const stage = r.data;
      this.solutionScreen = stage.solution;
      this.splitSolution();
    });
  },
  methods: {
    splitSolution() {
      let splittedSolution = this.solutionScreen.split(' ');
      console.log(splittedSolution);
      this.solutionLink = splittedSolution[splittedSolution.length -1];
      console.log(this.solutionLink);
      splittedSolution.forEach(element => {
        if(element === this.solutionLink) return;  
        this.solutionDescription += element + " ";
        //nao pode ter nem ponto no final
        //talvez valha a pena criar a historia pra criar slution no banco de dados
      });
      console.log(this.solutionDescription)
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
