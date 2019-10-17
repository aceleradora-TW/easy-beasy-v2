<template>
  <div class="hello">
    <h1>{{ hellomessage }}</h1>
  </div>
</template>

<script>
import service from '../services/pessoas.service'
export default {
  name: 'HelloWorld',
  data: function () {
    return {
      hellomessage: 'Hello World'
    }
  },
  props: {
    
  },

  async created() {
    const r = await service.getPessoas()
    // eslint-disable-next-line
    console.log(r);
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
