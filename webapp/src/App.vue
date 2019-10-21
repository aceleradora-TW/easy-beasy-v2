<template>
  <div id="app">
    <router-view></router-view>
    <Solution/>
  </div>
</template>

<script>

import Solution from '@/modules/Solutions/Solutions.vue'

export default {
  name: 'app',
  components: {
      Solution
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #00c1b9;
  background-color:#baf8fa;
}

</style>