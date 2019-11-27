<template>
  <div>
    <header>
      <h2>Cadastro de perguntas</h2>
      

    </header>
    <div class="inputLabel">
    <b-form-group label-cols="4" label-cols-default="2" label-size="default" label-for="input-default">
    <b-form-input id="input-default" size="default"></b-form-input>
    </b-form-group>
  
  
  </div>
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

.inputLabel{
  background-color: #ffffff; 
 
}
</style>


