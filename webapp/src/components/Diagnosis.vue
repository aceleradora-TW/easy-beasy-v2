<template>
  <div>
    <header>
      <h2>Diagnóstico</h2>
    </header>
    <Question/>
  </div>
</template>

<script>
import Question from '@/components/Question.vue'

  export default {
    name: "Diagnosis",
    components: {
      Question,
    }

  };
</script>

<style lang="scss">
@import '@/assets/scss/config/variables.scss';
header {
  justify-content: center;
  background-color: $backgound-header-color;
  padding: 5px 15px;
  font-family: $primary-font-family;
}
h2 {
  color: $text-header-color;
}
</style>