<template>
  <div>
    <header mb-5>
      <h2>Cadastro de perguntas</h2>
    </header>
    <b-container fluid class="containerInputs">
      <b-row>
        <b-col class="border-col-1 inputTitle">{{ questionText }}</b-col>
        <b-col class="border-col-1 inputTitle">{{ notUnderstandText }}</b-col>
      </b-row>
      <b-row align-h="center">
        <b-col>
          <b-form-group label-for="input-questionInput">
            <b-form-input
              id="input-questionInput"
              type="text"
              v-model.trim="$v.question.questionInput.$model"
              :state="
                $v.question.questionInput.$dirty
                  ? !$v.question.questionInput.$error
                  : null
              ">
            </b-form-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group label-for="input-notUnderstandInput">
            <b-form-input
              id="input-notUnderstandInput"
              type="text"
              v-model.trim="$v.question.notUnderstandInput.$model"
              :state="
                $v.question.notUnderstandInput.$dirty
                  ? !$v.question.notUnderstandInput.$error
                  : null
              ">
            </b-form-input>
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col class="border-col-1 inputTitle">{{ areaText }}</b-col>
        <b-col class="border-col-1 inputTitle">{{ stageText }}</b-col>
      </b-row>
      <b-row align-h="center">
        <b-col>
          <b-form-group label-for="input-areaInput">
            <b-form-input
              id="input-areaInput"
              type="text"
              v-model.trim="$v.question.areaInput.$model"
              :state="
                $v.question.areaInput.$dirty
                  ? !$v.question.areaInput.$error
                  : null
              ">
            </b-form-input>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group label-for="input-stageInput">
            <b-form-input
              id="input-stageInput"
              type="text"
              v-model.trim="$v.question.stageInput.$model"
              :state="
                $v.question.stageInput.$dirty
                  ? !$v.question.stageInput.$error
                  : null
              ">
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
            :disabled="$v.question.$invalid"
            >Salvar
          </b-button>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { required } from "vuelidate/lib/validators";

export default {
  components: {},
  name: "RegisterQuestions",

  data: () => ({
    question: {
      questionInput: "",
      notUnderstandInput: "",
      areaInput: "",
      stageInput: ""
    },
    areaText: "Área",
    questionText: "Pergunta",
    notUnderstandText: "Não entendi",
    stageText: "Estágio"
  }),
  validations: {
    question: {
      questionInput: {
        required
      },
      notUnderstandInput: {
        required
      },
      areaInput: {
        required
      },
      stageInput: {
        required
      }
    }
  },
  methods: {
    save() {
      this.$v.question.$touch();
      if (this.$v.question.$anyError) {
        return;
      }
      alert("Deuu Certo!!");
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
.inputTitle {
  text-align: left;
}
</style>
