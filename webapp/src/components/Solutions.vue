<template>
  <div>
    <p>{{solutionScreen}}</p>
  </div>
</template>

<script>
import solutions from "@/services/solutions.service";

export default {
  data: () => ({
    solutionScreen: ""
  }),
  created() {
    solutions.getSolutions().then(r => {
      this.solutionScreen = r.data.solution;
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
