<template>
  <div>
    <b-navbar toggleable="lg">
      <h2>Diagnóstico</h2>
    </b-navbar>
    <div class="chat">
      <div class="container">
        <p class="question">Você ta bem?</p>
        <div class="answer">
          <b-button id="answerYes">Sim</b-button>
          <b-button id="answerNo">Não</b-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Diagnosis"
};
</script>

<style scoped>
.answer {
  display: flex;
  justify-content: space-between;
  max-width: 200px;
  margin: 0 auto;
}
.answerYes{
  margin-left: 10px;
  margin-right: 10px;
}
.navbar {
  justify-content: center;
  background-color: #00d0c8;
  padding: 5px 15px;
}
.chat {
  text-align: center;
}

h2 {
  color: #2fc0d5;
}
</style>