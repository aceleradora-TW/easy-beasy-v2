<template>
  <div>
    <header mb-5>
      <h2>Cadastro de perguntas</h2>
    </header>
    <b-container fluid class="containerInputs">
      <b-row align-h="center">
      <b-col align-h="center" cols="1">{{area}}</b-col>
        <b-col cols="4">
          <b-form-group label-for="input-area">
            <b-form-input id="input-area"></b-form-input>
          </b-form-group>
        </b-col>

      <b-col align-h="center" cols="1">{{stage}}</b-col>
        <b-col cols="4">
          <b-form-group label-for="input-stage">
            <b-form-input id="input-stage"></b-form-input>
          </b-form-group>
        </b-col>
      </b-row>

      <b-row align-h="center">
      <b-col align-h="center" cols="1">{{question}}</b-col>
        <b-col cols="4">
          <b-form-group label-for="input-question">
            <b-form-input id="input-question"></b-form-input>
          </b-form-group>
        </b-col>

      <b-col align-h="center" cols="1">{{notUnderstand}}</b-col>
        <b-col cols="4">
          <b-form-grouplabel-for id="input-not-understand">
          <b-form-input id="input-not-understand"></b-form-input>
          </b-form-grouplabel-for>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  components: {

  },
  name: "RegisterQuestions",

  data: () => ({
    area: "Área",
    stage: "Estágio",
    question: "Pergunta",
    notUnderstand: "Explicação botão Não Entendi "
  })
};
</script>

<style lang="scss">
@import "@/assets/scss/config/variables.scss";
header {
  justify-content: center;
  background-color: $backgound-header-color;
  padding: 5px 15px;
  font-family: $primary-font-family;
}
h2 {
  color: $text-header-color;
}
.lineTop {
  background-color: $secondary-color;
  color: $secondary-color;
  height: 2rem;
}
.containerInputs {
  padding: 0.5rem;
}
</style>
