<template>
  <div>
    <b-button v-b-modal.modal>NPS</b-button>

    <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modal">
      <p>O quanto você recomendaria este diagnóstico para um amigo?</p>
      <b-button
      class="ml-6"
        squared
        variant="outline-secondary"
        v-on:click="getScore(number)"
        v-for="number in 10"
        :key="number">{{ number }}</b-button>

      <label class="mt-20">Qual a razão da sua nota?</label>    
      <b-input id="input" v-model="comments"></b-input>

      <b-container fluid>
        <b-row class="mb-3">
          <b-col md="1.5" class="ml-md-auto">
            <b-button squared type="submit" v-on:click="$bvModal.hide('modal')" class="mt-20">enviar</b-button>
          </b-col>
        </b-row>
      </b-container>
    </b-modal>
  </div>
</template>

<script>
export default {
  name: "Modal",

  data: () => ({
    score: 0,
    comments: ""
  }),
  methods: {
    getScore(number) {
      this.score = number;
    }
  }
};
</script>

<style lang="scss" scoped>
.mt-20 {
  margin-top: 20px;
}
.ml-6{
  margin-left: 6px;
}

</style>
