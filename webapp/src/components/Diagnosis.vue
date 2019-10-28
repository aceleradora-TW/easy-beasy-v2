<template>
  <div>
    <header>
      <h2>Diagnóstico</h2>
    </header>
    <Question />
  </div>
</template>

<script>
import Question from '@/components/Question.vue'

  export default {
    name: "Diagnosis",
    components: {
      Question
    }
  };
</script>

<style lang="scss">
<style lang="scss" scoped>
  @media (min-width: 100px){
  header {
    justify-content: center;
    background-color: #e2e2e2;
    padding: 5px 15px;
  }
  h2 {
    color: #cccccc;
  }
  .chat {
    background-color: #ffffff;
    position: fixed;
    width: 100%;
    overflow-y: hidden;
    padding: 2rem;


    .question {
      text-align: left;
      color: #b1b1b1;

      img {
        border-radius: 50%;
        width: 1.5rem;
      }
    }

    .answer {
      text-align: right;
      color: #636363;
    }
  }

  .footer {
    position: fixed;
    bottom: 0rem;
    width: 100%;
    background-color: #ffffff;

    .answer-buttons {
      display: flex;
      justify-content: space-between;
      max-width: 200px;
      margin: 0 auto;
      padding: 0.5rem;
      bottom: 10px;

      .answer-btn {
        background-color: #2fc0d5;
        border-color: #2fc0d5;
      }
    }
  }
</style>