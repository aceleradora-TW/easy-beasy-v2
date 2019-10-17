<template> 
<div> 
  <h1>{{text}}</h1>
  <p>olaaaaaaaah</p>
  <h1>{{solutionTela}}</h1>
</div>
 
</template>

<script>
import solution from '../services/solution'

export default {
  name: 'Home',
  props: {
    msg: String
  },
  data: () => ({
    text:"Hello",
    solutionTela: ""
  }),

  created() {
   solution.solution().then(r => {
     this.solutionTela = r.data.solution;
      console.log(r.data.solution);
     
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
