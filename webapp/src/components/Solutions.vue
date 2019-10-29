<template> 
<div> 
  <h1>{{text}}</h1>
  <p></p>
  <h1>{{solutionScreen}}</h1>
</div>
 
</template>

<script>
import solutions from '@/services/solutions.service.js'

export default {
  data: () => ({
    text:"",
    solutionScreen: ""
  }),

  created() {
   solutions.getSolutions().then(r => {
     this.solutionScreen = r.data.solutions;
     console.log(r.data.solutions);
    })
  }
}
</script>

<style scoped lang = "scss">

</style>
