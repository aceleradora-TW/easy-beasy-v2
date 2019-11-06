<template>
    <div>
        <b-button v-b-modal.modal>Coleta de dados</b-button>

        <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modal">
            <p>
                <strong>Por favor, nos informe nome e email para receber o diagnóstico.</strong>
            </p>

            <b-container fluid>
                <b-row class="mb-3">
                    <b-col md="1.5" class="ml-md-auto">
                        <b-button squared type="submit" v-on:click="$bvModal.hide('modal')" class="answer-btn mt-20">
                            enviar
                        </b-button>
                    </b-col>
                </b-row>
            </b-container>
        </b-modal>
    </div>
</template>

<script>
    export default {
        name: "ModalData",

        data: () => ({
            nameUser: "",
            emailUser: ""
        }),
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

    .answer-btn:hover {
        background-color: #2fc0d5;
        border-color: #2fc0d5;
    }

    .mt-20 {
        margin-top: 20px;
    }
</style>
