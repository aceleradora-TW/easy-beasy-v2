<template>
  <div>
    <b-button v-b-modal.modal>NPS</b-button>

    <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modal">
      <p>
        <strong>Em uma escala de 1 a 10, o quanto você recomendaria o nosso serviço para alguém?</strong>
      </p>

      <b-button
        class="ml-6"
        squared
        variant="outline-secondary"
        v-on:click="getScore(number)"
        v-for="number in 10"
        :key="number"
      ><strong>{{ number }}</strong></b-button>

      <label class="mt-20">Qual a razão da sua nota?</label>
      <b-input id="input" v-model="comments"></b-input>

      <b-container fluid>
        <b-row class="mb-3">
          <b-col md="1.5" class="ml-md-auto">
            <b-button squared type="submit" v-on:click="$bvModal.hide('modal'), submitScore()" class="answer-btn mt-20">enviar</b-button>
          </b-col>
        </b-row>
      </b-container>
    </b-modal>
  </div>
</template>

<script>
import netPromoterScoreService from '@/services/netPromoterScore.service.js'

export default {
  name: "Modal",

  data: () => ({
    score: 0,
    comments: ""
  }),

  methods: {
    getScore(number) {
      this.score = number;
    },

    submitScore() {
      netPromoterScoreService.save({
        score: this.score,
        comments: this.comments
      })
        .then(response => alert(response.status))
        .catch(error => alert(error))
    }
  }
};
</script>

<style lang="scss" scoped>
.ml-6 {
  margin-left: 6px;
}
.answer-btn {
  background-color: #2fc0d5;
  border-color: #2fc0d5;
}
.answer-btn:hover{
  background-color: #2fc0d5;
  border-color: #2fc0d5;
}
.mt-20{
  margin-top: 20px;
}
</style>
