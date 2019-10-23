<template> 
<div> 
  <h1>{{text}}</h1>
  <p>Teste</p>
  <h1>{{solutionScreen}}</h1>
</div>
 
</template>

<script>
import solution from '@/services/solution.service.js'

export default {
  data: () => ({
    text:"Teste Entrega a Solução",
    solutionScreen: ""
  }),

  created() {
   solution.getSolution().then(r => {
     this.solutionScreen = r.data.solution;
     console.log(r.data.solution);
    })
  }
}
</script>

<style scoped lang = "scss">

</style>
