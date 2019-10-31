<template>
    <div class="chat">
        <b-container class="chat-box">
            <b-row align-h="start">
                <b-col cols="auto"><img src="@/assets/images/easybeasy-logo.jpeg" alt="logo"/></b-col>
                <b-col cols="9" class="question">
                    Bem vindo a Easybeasy! A nossa
                        plataforma irá
                        realizar o diagnóstico da sua empresa a partir de perguntas e respostas de “sim” ou “não”.
                        Vamos
                        começar!

                </b-col>


            </b-row>
            <div class="question" v-for="question in chatHistory" v-bind:key="question.description">
                <b-row>
                    <b-col cols="auto"><img src="@/assets/images/easybeasy-logo.jpeg" alt="logo"/></b-col>
                    <b-col cols="9" class="question">

                            {{question.description}}

                    </b-col>
                </b-row>
                <b-row align-h="end">
                    <b-col cols="2" class="answer">
                        {{question.response}}
                    </b-col>
                </b-row>
            </div>
        </b-container>
        <b-row class="footer">
            <div class="answer-buttons">
                <b-button squared class="answer-btn" v-on:click="collectPositiveAnswer()">Sim</b-button>
                <b-button squared class="answer-btn" v-on:click="collectNegativeAnswer()">Não</b-button>
            </div>
        </b-row>
    </div>
</template>

<script>
import questionService from "@/services/questions.service.js";


export default {
    name: "Question",

    data: () => ({
        questionList: [],
        chatHistory: [],
        userResponseHistory: [],
        negativeCount: null,
        index: null
    }),

    created() {
        questionService.getQuestions().then(list => {
            this.questionList = list.data;
            this.nextQuestion();
            this.index = 0;
        });
    },
    methods: {
        nextQuestion() {
            this.chatHistory.push({
                response: "",
                description: this.questionList.shift().description
            });
        },
        collectPositiveAnswer() {
            if (this.chatHistory[this.index].response === "") {
                this.chatHistory[this.index].response = "Sim";
                if (this.questionList.length !== 0) {
                    this.index++;
                    this.nextQuestion();
                }
            }
        },
        collectNegativeAnswer() {
            if (this.chatHistory[this.index].response === "") {
                this.chatHistory[this.index].response = "Não";
                if (this.questionList.length !== 0) {
                    this.index++;
                    this.negativeCount++;
                    this.nextQuestion();
                }
            }

        },
    }

};
</script>

<style lang="scss">
@media (min-width: 100px) {
    .chat {
        background-color: #ffffff;
        position: fixed;
        width: 100%;
        height: 86%;
        overflow-y: scroll;

        .chat-box {
            padding: 3rem 2rem;

            img {
                border-radius: 50%;
                width: 1.5rem;
            }

            .question {
                text-align: left;
                color: #b1b1b1;
                margin-bottom: 15px;
            }

            .answer {
                color: #636363;
                margin-bottom: 15px;
            }
        }
        .footer {
            position: fixed;
            align-items: center;
            bottom: 0;
            width: 100%;
            background-color: #ffffff;

            .answer-buttons {
                display: flex;
                justify-content: space-between;
                max-width: 200px;
                margin: 0 auto;
                padding: 0.5rem;
                bottom: 10px;

                .answer-btn {
                    background-color: #2fc0d5;
                    border-color: #2fc0d5;
                }
            }
        }

    }
}
</style>