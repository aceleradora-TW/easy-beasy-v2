<template>
  <div class="hello">
    <Diagnosis/>  
  </div>
</template>

<script>
import service from '../services/pessoas.service'
import Diagnosis from '../components/Diagnosis';

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  components:{
    Diagnosis
  },
  created() {
    service.getPessoas().then(r => {
      // eslint-disable-next-line
      console.log(r);
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
  color: rgb(0, 110, 255);
}
</style>
