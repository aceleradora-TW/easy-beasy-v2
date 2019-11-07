<template>
    <div>
        <b-button v-b-modal.modal>NPS</b-button>

        <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modal">
            <p>
                <strong>Em uma escala de 1 a 10, o quanto você recomendaria o nosso serviço para alguém?</strong>
            </p>
            <b-button

                    class="ml-6 font nps-button"
                    squared
                    variant="outline-secondary"
                    v-on:click="getScore(number), changeBackGroundColor($event)"
                    v-for="number in 10"
                    :key="number">{{ number }}
            </b-button>

            <label class="mt-20">Qual a razão da sua nota?</label>
            <b-input id="input" v-model="nps.comments"></b-input>

            <b-container fluid>
                <b-row class="mb-3">
                    <b-col md="1.5" class="ml-md-auto">
                        <b-button squared type="submit" v-on:click="$bvModal.hide('modal'), submitScore()"
                                  class="answer-btn mt-20">enviar
                        </b-button>
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
            nps : {
                score: 0,
                comments: ""
            }
        }),
        methods: {
            getScore(number) {
                this.nps.score = number;
            },
            submitScore() {
                netPromoterScoreService.save(this.nps).then(response => alert("Sua nota foi enviada com sucesso!"))
                .catch(error => alert(error))
            },
            changeBackGroundColor(event) {
                const allButtons = document.querySelectorAll(".nps-button");
                for (let i = 0; i < allButtons.length; i++) {
                    allButtons[i].style.backgroundColor = "#ffffff";
                }
                const button = event.currentTarget;
                button.style.background = "#bcbcbc";
            }
        }
    };
</script>

<style lang="scss" scoped>
    .ml-6 {
        margin-left: 6px;
    }
    .font{
        font-weight: bold;
        font-size: 18px;
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
