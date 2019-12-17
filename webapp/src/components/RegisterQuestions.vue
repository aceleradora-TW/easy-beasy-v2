<template>
  <div>
    <header mb-5>
      <h2>Cadastro de perguntas</h2>
    </header>
    <b-container fluid class="containerInputs">
      <b-row>
        <b-col class="border-col-1 inputTitle">{{ questionText }}</b-col>
      </b-row>
      <b-row align-h="center">
        <b-col>
          <b-form-group label-for="input-description">
            <b-form-input
              id="input-description"
              type="text"
              v-model.trim="$v.question.description.$model"
              :state="
                $v.question.description.$dirty
                  ? !$v.question.description.$error
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
          <b-form-group label-for="dropdown-areaDropdown">
            <select class="form-control">
              <option v-for="area in areaList"
              v-bind:key="area.name">{{ area.name }}</option>
            </select>
          </b-form-group>
        </b-col>
        <b-col>
          <b-form-group label-for="dropdown-id_stage">
            <select class="form-control" :options="stages">
                <option v-for="stage in stageList"
                v-bind:key="stage.number" value="stage.number" v-on:click="setIdStage(stage.number)">{{ stage.number }}</option>
              </select>
          </b-form-group>
        </b-col>
      </b-row>
    </b-container>
    <b-container>
      <b-row class="mb-3">
        <b-col md="1.5" class="ml-md-auto">
          <div id="container" class="answer-buttons">
            <b-button
              squared
              type="submit"
              v-on:click="save(question)"
              class="saveQuestion answer-btn mt-20"
              :disabled="$v.question.$invalid" 
              >Salvar
            </b-button>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { required } from "vuelidate/lib/validators";
import StageService from "@/services/stage.service.js";
import AreaService from "@/services/area.service.js";
import QuestionService from "@/services/question.service.js";

export default {
  components: {},
  name: "RegisterQuestions",

  data: () => ({
    question: {
      description: "",
      id_stage: 0
    },
    areaText: "Área",
    questionText: "Pergunta",
    stageText: "Estágio",
    stageList: [],
    areaList: []
    }),
    validations: {
      question: {
        description: {
        required
      },
    }
  },
  created() {
    StageService.getStages()
      .then(response => {
        this.stageList = response.data;
      })
      .catch(error => {});

    AreaService.getAreas()
      .then(response => {
        this.areaList = response.data;
      })
      .catch(error => {});
  },
  methods: {
    setIdStage(number) {
      this.question.id_stage = number;
    },
    save() {
      this.$v.question.$touch();
      if (this.$v.question.$anyError) {
        return;
      }
      QuestionService.save(this.question);
      alert("Pergunta cadastrada com sucesso!");
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
#container {
  display: flex;
  justify-content: space-between;
  padding: 0.5rem 0.5rem 30px 0.5rem;

  .answer-btn {
    background-color: $primary-color;
    border-color: $primary-color;
  }
  .answer-buttons {
    max-width: 200px;
    margin: 0 auto;
    padding: 0.5rem;
    bottom: 10px;
  }
}
</style>
