<template>
  <div>
    <b-button
      class="doubt-btn"
      id="show-btn"
      v-on:click="$bvModal.show('bv-modal-example')"
    >Não entendi</b-button>

    <b-modal id="bv-modal-example" hide-footer>
      <template v-slot:modal-title>Prioridade</template>
      <div class="ml-3 mr-3">
        <p>
          Pense no seu dia a dia,
          se você sabe qual o próximo passo que deve ser tomado e para onde está indo,
          se tem esclarecido quais e quando suas tarefas devem ser feitas.
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
export default {
  name: "ModalDoubt"
};
</script>

<style scoped>
.answer-btn:hover {
  background-color: #2fc0d5;
  border-color: #2fc0d5;
}
.answer-btn {
  background-color: #2fc0d5;
  border-color: #2fc0d5;
}
</style>