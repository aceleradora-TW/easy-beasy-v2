<template>
    <div>
        <b-button class="dontUnderstand-btn" id="show-btn" @click="$bvModal.show('bv-modal-example')">Não entendi</b-button>

    <b-modal id="bv-modal-example" hide-footer>
        <template v-slot:modal-title>
            Titulo da area
        </template>
        <div class="d-block text-center">
            <h3>Explicação da pergunta</h3>
        </div>
        <b-button class="answer-btn mt-20" block @click="$bvModal.hide('bv-modal-example')">Entendi</b-button>
    </b-modal>
    </div>
</template>

<script>
    export default {
        name: "ModalNaoEntendi"
    }
</script>

<style scoped>

</style>