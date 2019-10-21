<template> 
<div> 
  <h1>{{text}}</h1>
  <p>Teste</p>
  <h1>{{solutionScreen}}</h1>
</div>
 
</template>

<script>
import solution from '@/services/solution'

export default {
  name: 'Home',
  props: {
    msg: String
  },
  data: () => ({
    text:"Hello",
    solutionScreen: ""
  }),

  created() {
   solution.getSolution().then(r => {
     this.solutionScreen = r.data.solution;
    })
    
  }
}
</script>

<style scoped lang = "scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
