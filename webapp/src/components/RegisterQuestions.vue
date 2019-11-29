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
            <b-form-input 
            id="input-area"
            type="text"
            v-model.trim="$v.question.areaInput.$model"
            :state="$v.question.areaInput.$dirty ? !$v.question.areaInput.$error : null"
            >            
            </b-form-input>
          </b-form-group>
        </b-col>
      </b-row>
    </b-container>
    <b-container fluid>
      <b-row class="mb-3">
        <b-col md="1.5" class="ml-md-auto">
          <b-button
            squared
            type="submit"
            v-on:click="save()"
            class="saveQuestion answer-btn mt-20"
            :disabled="$v.question.areaInput.$invalid"
          >Salvar</b-button>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { required } from "vuelidate/lib/validators";

export default {
  components: {

  },
  name: "RegisterQuestions",

  data: () => ({
    question: {
      areaInput: ""
    
    },
    area: "Área"
  }),
   validations: {
     question:{
      areaInput: {
        required,
      },
     }
  },
  methods: {
    save(){
     this.$v.question.$touch()
        if (this.$v.question.$anyError) {
        return
      }
      alert("Deuu Certo!!")
    }
  }
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
  background-color: $secondary-color;
  font-family: $primary-font-family;
  color: $answer-text-color;
}
</style>
