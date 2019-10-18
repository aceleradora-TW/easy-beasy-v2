<template>
  <div>
    <header>
      <h2>Diagnóstico</h2>
    </header>
    <div class="chat">
      <p id="pergunta">Você tem uma organização de tempo e tarefas?</p>
      <p id="resp">Não.</p>
      <p id="pergunta">Você geralmente esquece de coisas que precisam ser feitas?</p>
      <p id="resp">Não.</p>
      <p id="pergunta">Você organiza a semana em tarefas e metas a serem cumpridas?</p>
      
    </div>
    <div class="footer">
      <div class="answer">
        <b-button squared id="answerBtn">Sim</b-button>
        <b-button squared id="answerBtn">Não</b-button>
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
  overflow: auto;
  padding: 2rem;
}
.footer {
  position: fixed;
  bottom: 2rem;
  width: 100%;
}
.answer {
  display: flex;
  justify-content: space-between;
  max-width: 200px;
  margin: 0 auto;
  padding: 0.5rem;
  bottom: 10px;
}
#pergunta {
  text-align: left;
  color: #b1b1b1;
}
#resp {
  text-align: right;
  color: #636363;
}
#answerBtn{
  background-color: #2fc0d5;
  border-color: #2fc0d5;
}
</style>