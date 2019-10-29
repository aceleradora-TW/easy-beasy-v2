<template> 
<div> 
  <h1>{{text}}</h1>
  <p></p>
  <h1>{{solutionScreen}}</h1>
</div>
 
</template>

<script>
import solutions from '../services/solutions.service'

export default {
  data: () => ({
    text:"",
    solutionScreen: ""
  }),

  created() {
   solutions.getSolutions().then(r => {
     this.solutionScreen = r.data.solution;
     console.log(r.data.solution);
    })
  }
}
</script>

<style scoped lang = "scss">

</style>
