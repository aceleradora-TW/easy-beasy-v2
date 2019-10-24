<template>
<div>
  <b-button v-b-modal.modal>NPS</b-button>

  <b-modal id="modal" >
    <p>O quanto você recomendaria este diagnóstico para um amigo?</p>
  </b-modal>

</div>
</template>

<script>
  export default {
    name: "Modal"
  };
</script>
