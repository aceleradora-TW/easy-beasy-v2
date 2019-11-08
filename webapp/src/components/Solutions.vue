<template>
  <div>
    <p>{{solutionScreen}}</p>
  </div>
</template>

<script>
import Solution from "@/services/solutions.service";

export default {
  data: () => ({
    solutionScreen: "",
    id: 0
  }),
  created() {
    Solution.getSolutions(this.id).then(r => {
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
