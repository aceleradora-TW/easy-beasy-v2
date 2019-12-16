<template>
  <div>
    <b-button
      class="modal-question-btn"
      id="show-btn"
      v-on:click="$bvModal.show('bv-modal-example')" :disabled="disableButtonNotUnderstand"
    >Não entendi</b-button>

    <b-modal id="bv-modal-example" hide-footer>
      <template v-slot:modal-title>Prioridade</template>
      <div class="ml-3 mr-3">
        <p>
          {{ idStage }}
        </p>
      </div>
      <b-container fluid>
        <b-row class="mb-3">
          <b-col md="1.5" class="ml-md-auto">
            <b-button
              squared
              type="submit"
              v-on:click="$bvModal.hide('bv-modal-example')"
              class="answer-btn mt-20"
            >Entendi</b-button>
          </b-col>
        </b-row>
      </b-container>
    </b-modal>
  </div>
</template>

<script>
import StageService from "@/services/stage.service.js";

export default {
  name: "ModalQuestion",
  props: {
  disableButtonNotUnderstand: { type: Boolean },
  idStage: { type: Number }
  },
  data: () => ({
    hint: ""
  }),
  // methods: {
  //   created() {
  //     StageService.getStageById(this.idStage)
  //     .then(response => {
  //       this.hint = response.data.stage.hint
  //     })
  //   }
  // },
};
</script>

<style lang="scss" scoped>
@import '@/assets/scss/config/variables.scss';

.answer-btn:hover {
  background-color:$primary-color;
  border-color: $primary-color;
}
.answer-btn {
  background-color:$primary-color;
  border-color: $primary-color;
}
</style>