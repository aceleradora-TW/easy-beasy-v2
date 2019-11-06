<!--<template>-->
<!--  <div class="user">-->
<!--    <b-form>-->
<!--      <input type="hidden"/>-->
<!--      <b-row>-->
<!--          <b-col md="6" sm="12">-->
<!--            <b-form-group label-for="user-name">-->
<!--              <b-form-input id="user-name" type="text" v-model="user.name" :state="null" required placeholder="Informe seu nome"/>-->
<!--              <span class = "invalidName" v-if="!isNameValid">Nome invalido/vazio!</span>-->
<!--            </b-form-group>-->
<!--          </b-col>-->
<!--      </b-row>-->
<!--      <input type="hidden"/>-->
<!--      <b-row>-->
<!--          <b-col md="6" sm="12">-->
<!--            <b-form-group label-for="user-email">-->
<!--              <b-form-input id="user-email" type="email" v-model="user.email" required placeholder="exemplo@gmail.com"/>-->
<!--            <span v-if="!isEmailValid">Informe seu email!</span>-->
<!--            </b-form-group>-->
<!--          </b-col>-->
<!--      </b-row>-->
<!--      <b-button class="saveUser" v-on:click="save(user)">Salvar</b-button>-->
<!--    </b-form>-->
<!--  </div>-->
<!--</template>-->
<!--​-->
<!--<script>-->
<!--import userService from "@/services/user.service.js"-->
<!--import { required, email } from "vuelidate/lib/validators";-->

<!--export default {-->
<!--  name: "User",-->
<!--  data: () => ({-->
<!--    user: {-->
<!--      name: "",-->
<!--      email: ""-->
<!--    },-->
<!--    isNameValid: true,-->
<!--    isEmailValid: true-->
<!--  }),-->
<!--  validations: {-->
<!--    user: {-->
<!--      name: { required },-->
<!--      email: { required, email }-->
<!--    }-->
<!--  }, -->
<!--  methods:{-->
<!--      save(user){-->
<!--      if(user.name == "" || user.email == "")-->
<!--      {-->
<!--        alert ("Por favor, preencha os seguintes campos.");-->
<!--        if(user.name == "")-->
<!--        {-->
<!--          alert ("Informe um nome.");-->
<!--        }-->
<!--        // if(user.email == email)-->
<!--        // {-->
<!--        //   alert ("Informe o email.");-->
<!--       // }-->
<!--     }-->
<!--      }-->
<!--      -->
<!--   },-->
<!--  //  checkName:{-->
<!--  //   if(isNameValid){-->

<!--  //   }-->
<!--  //  }-->
<!--  //   }-->
<!--}-->
<!-- -->
<!--</script>-->
<!--<style scoped>-->
<!--.user{-->
<!--  text-align: justify;-->
<!--  background-color: white;-->
<!--}-->
<!--</style>-->