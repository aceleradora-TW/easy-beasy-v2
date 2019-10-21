<template>
  <div>
    <header>
      <h2>Diagnóstico</h2>
    </header>
    <div class="chat">
      <p class="pergunta">Você tem uma organização de tempo e tarefas?</p>
      <p class="resp">Não.</p>
      <p class="pergunta">Você geralmente esquece de coisas que precisam ser feitas?</p>
      <p class="resp">Não.</p>
      <p class="pergunta">Você organiza a semana em tarefas e metas a serem cumpridas?</p>
    </div>
    <div class="footer">
      <div class="answer">
        <b-button squared class="answerBtn">Sim</b-button>
        <b-button squared class="answerBtn">Não</b-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Diagnosis"
};
</script>

<style lang="scss" scoped>
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


  .pergunta {
    text-align: left;
    color: #b1b1b1;
  }

  .resp {
    text-align: right;
    color: #636363;
  }
}
.footer {
  position: fixed;
  bottom: 2rem;
  width: 100%;
  background-color: #ffffff;

  .answer {
    display: flex;
    justify-content: space-between;
    max-width: 200px;
    margin: 0 auto;
    padding: 0.5rem;
    bottom: 10px;

    .answerBtn {
      background-color: #2fc0d5;
      border-color: #2fc0d5;
    }
  }
}
</style>