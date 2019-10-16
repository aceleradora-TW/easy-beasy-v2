<template>
    <div class="pergunta-container">
        <h1>Diagnóstico</h1>
        <div class="contaienr">
            <md-button v-on:click="obterPerguntas" class="md-green">
                Buscar perguntas
                <md-progress-spinner
                        class="md-accent"
                        :md-diameter="20"
                        md-mode="indeterminate"
                        v-if="$data.isLoading">
                </md-progress-spinner>
            </md-button>
            <md-content>
                <ul id="example-1">
                    <li v-bind:key="pergunta" v-for="pergunta in listDePerguntas">
                        {{ pergunta }}
                    </li>
                </ul>
            </md-content>
        </div>
    </div>
</template>


<style lang="scss" scoped>
    .pergunta-container {

        button {
            background-color: rgb(0, 208, 200);
        }

        h1 {
            background-color: #e2e2e2;
            height: 50px;
            margin: 0px;
            text-align: center;
            padding: 12px;
            color: #a09b9b;
        }

        .contaienr {
            background-color: #ffffff;
        }

        height: 850px;
        background-color: #ffffff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
    }
</style>

<script>
    import request from './../../utils/request'

    export default {
        name: 'perguntas',
        data() {
            return {
                listDePerguntas: [],
                isLoading: false
            }
        },
        methods: {
            obterPerguntas() {
                this.listDePergunta = [];
                this.isLoading = true;
                request.get('/perguntas')
                    .then((response) => {
                    // apenas para interromper um pouco
                    setTimeout(() => {
                        this.listDePerguntas = response.data;
                        this.isLoading = false;
                    },2000)
                });
            }
        }
    }
</script>