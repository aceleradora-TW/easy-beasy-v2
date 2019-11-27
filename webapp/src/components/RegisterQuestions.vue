<template>
  <div>
    <header>
      <h2>Cadastro de perguntas</h2>
    </header>
    <b-container fluid>
      <b-row align-h="center">
          <b-col cols="4">
            <b-form-group label-for="input-default">
              <b-form-input id="input-default"></b-form-input>
            </b-form-group>      
          </b-col>
          <b-col cols="4">
            <b-form-group label-for="input-default">
              <b-form-input id="input-default"></b-form-input>
            </b-form-group>
          </b-col>  
      </b-row>   
    </b-container>
  </div>
</template>

<script>
export default {
  name: "RegisterQuestions"
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
</style>
