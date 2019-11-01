<template>
  <div>
    <b-button
      class="dontUnderstand-btn"
      id="show-btn"
      v-on:click="$bvModal.show('bv-modal-example')"
    >Não entendi</b-button>

    <b-modal id="bv-modal-example" hide-footer>
      <template v-slot:modal-title>Explicação Financeiro</template>
      <div class="text">
        <h3>Explicação</h3>
      </div>
      <b-container fluid>
        <b-row class="mb-3">
          <b-col md="1.5" class="ml-md-auto">
            <b-button
              squared
              type="submit"
              v-on:click="$bvModal.hide('modal')"
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
.answer-btn:hover{
  background-color: #2fc0d5;
  border-color: #2fc0d5;
}
.answer-btn {
  background-color: #2fc0d5;
  border-color: #2fc0d5;
}
</style>