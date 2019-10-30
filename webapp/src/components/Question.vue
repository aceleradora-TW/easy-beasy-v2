<template>
    <div>
        <div class="chat">
            <div class="chat-box">
                <p class="question">
                    <img src="@/assets/images/easybeasy-logo.jpeg" alt="logo"/>Bem vindo a Easybeasy! A nossa plataforma irá
                    realizar o diagnóstico da sua empresa a partir de perguntas, e respostas de “sim” ou “não”. Vamos
                    começar!
                </p>
                <div class="question" v-for="question in chatHistory" v-bind:key="question.description">
                    <p><img src="@/assets/images/easybeasy-logo.jpeg" alt="logo"/> {{question.description}}</p>
                    <p class="answer">{{question.response}}</p>
                </div>
            </div>
            <div class="footer">
                <div class="answer-buttons">
                    <b-button squared class="answer-btn" v-on:click="collectPositiveAnswer()">Sim</b-button>
                    <b-button squared class="answer-btn" v-on:click="collectNegativeAnswer()">Não</b-button>
                </div>
            </div>
        </div>
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

            .chat-box{
                padding: 3rem 2rem;

                .answer {
                    text-align: right;
                    color: #636363;
                }

                .question {
                    text-align: left;
                    color: #b1b1b1;

                    img {
                        border-radius: 50%;
                        width: 1.5rem;
                    }
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