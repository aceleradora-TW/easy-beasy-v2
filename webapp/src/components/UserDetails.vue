<template>
  <div class="hello">
    <h1>This is user details</h1>
  </div>
</template>

<script>
import service from '../services/pessoas.service'
export default {
  name: 'UserDetails',
  props: {
    msg: String
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
  color: #42b983;
}
</style>
