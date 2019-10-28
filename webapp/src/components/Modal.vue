<template>
  <div>
    <b-button v-b-modal.modal>NPS</b-button>

    <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modal">
      <p>O quanto você recomendaria este diagnóstico para um amigo?</p>
      <b-button squared class="scoreButton" variant="outline-secondary" v-on:click="getScore(number)" v-for="number in 10" :key="number">{{ number }}</b-button>
      <b-input id="input" v-model="comments"></b-input>
      <p>{{comments}}</p>
      <p>{{score}}</p>
      <b-button type="submit" v-on:click="$bvModal.hide('modal')">enviar</b-button>
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
      this.score = number
    }
  }
};
</script>

<style lang="scss" scoped>
  .scoreButton{
    // border: solid gray;
    // border-width: 1px;
    margin: 5px;
    // color: gray;
  }
</style>
