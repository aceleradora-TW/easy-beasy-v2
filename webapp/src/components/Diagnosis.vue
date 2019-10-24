<template>
  <div>
    <header>
      <h2>Diagnóstico</h2>
    </header>
    <div class="chat">
      <p class="question"><img src="../assets/images/easybeasy-logo.jpeg" alt="logo"> Você tem uma organização de tempo e tarefas?</p>
      <p class="answer">Não.</p>
      <p class="question"><img src="../assets/images/easybeasy-logo.jpeg" alt="logo"> Você geralmente esquece de coisas que precisam ser feitas?</p>
      <p class="answer">Não.</p>
      <p class="question"><img src="../assets/images/easybeasy-logo.jpeg" alt="logo"> Você organiza a semana em tarefas e metas a serem cumpridas?</p>
    

    
    </div>
          
    <div class="footer">
          <div class="answer-buttons">
        <b-button squared class="answer-btn">Sim</b-button>
        <b-button squared class="answer-btn">Não</b-button>
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
    bottom: 2rem;
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
  }}
</style>