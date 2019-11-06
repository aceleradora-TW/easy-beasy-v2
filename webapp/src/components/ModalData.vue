<template>
    <div>
        <b-button v-b-modal.modal>Coleta de dados</b-button>

        <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modal">
            <p>
                <strong>Por favor, nos informe nome e email para receber o diagnóstico.</strong>
            </p>

            <b-row>
                <b-col md="6" sm="12">
                    <b-form-group label-for="user-name">
                        <b-form-input id="user-name" type="text" v-model="user.name" :state="null" required placeholder="Informe seu nome"/>
                        <span class = "invalidName" v-if="!isNameValid">Nome invalido/vazio!</span>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row>
                <b-col md="6" sm="12">
                    <b-form-group label-for="user-email">
                        <b-form-input id="user-email" type="email" v-model="user.email" required placeholder="exemplo@gmail.com"/>
                        <span v-if="!isEmailValid">Informe seu email!</span>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-container fluid>
                <b-row class="mb-3">
                    <b-col md="1.5" class="ml-md-auto">
                        <b-button squared type="submit" v-on:click="$bvModal.hide('modal') && save()" class="saveUser">Salvar</b-button>
                    </b-col>
                </b-row>
            </b-container>
        </b-modal>
    </div>
</template>
<script>
    import userService from "@/services/user.service"
    import { required, email } from "vuelidate/lib/validators";

    export default {
        name: "ModalData",
        data: () => ({
            user: {
                name: "",
                email: ""
            },
            isNameValid: true,
            isEmailValid: true
        }),
        validations: {
            user: {
                name: { required },
                email: { required, email }
            }
        },
        methods:{
            save(){

                // if(user.name == "" || user.email == "")
                // {
                //     alert ("Por favor, preencha os seguintes campos.");
                //     if(user.name == "")
                //     {
                //         alert ("Informe um nome.");
                //     }
                    // if(user.email == email)
                    // {
                    //   alert ("Informe o email.");
                    // }
                // }
                userService.save(this.user);
            }

        }
        //  checkName:{
        //   if(isNameValid){

        //   }
        //  }
        //   }
    }

</script>
<style scoped>
    .user{
        text-align: justify;
        background-color: white;
    }
</style>