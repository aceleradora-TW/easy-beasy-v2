<template> 
<div> 
  <h1>{{text}}</h1>
  <p>olaaaaaaaah</p>
  <h1>{{solutionTela}}</h1>
</div>
 
</template>

<script>
import service from '../services/pessoas.service'
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
    service.getCoco().then(r => {
      // eslint-disable-next-line
      console.log(r);
      
    })
    solution.solution().then(response =>{
      this.solutionTela = response.data.solution
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
