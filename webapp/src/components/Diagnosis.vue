<template>
  <div>
    <!-- <header> -->
      <!-- <h2>Diagnóstico</h2> -->
    <!-- </header> -->
    <!-- <Question/> -->
  <User/>
  </div>
</template>

<script>
import Question from '@/components/Question.vue'
import User from '@/components/User'

  export default {
    name: "Diagnosis",
    components: {
      Question,
      User
    }

  };
</script>

<style lang="scss">
header {
  justify-content: center;
  background-color: #e2e2e2;
  padding: 5px 15px;
}
h2 {
  color: #cccccc;
}
</style>