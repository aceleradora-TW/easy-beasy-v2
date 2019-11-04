<template>
  <div class="user">
    <b-form>
      <input type="hidden"/>
      <b-row>
          <b-col md="6" sm="12">
            <b-form-group label-for="user-name">
              <b-form-input id="uer-name" type="text" v-model="user.name" :state="nameState" required placeholder="Informe seu nome"/>
              <span v-if="!isNameValid">Nome invalido/vazio!</span>
            </b-form-group>
          </b-col>
      </b-row>
      <input type="hidden"/>
      <b-row>
          <b-col md="6" sm="12">
            <b-form-group label-for="user-email">
              <b-form-input id="user-email" type="email" v-model="user.email" required placeholder="exemplo@gmail.com"/>         
            <span v-if="!isEmailValid">Informe seu email!</span>
            </b-form-group>
          </b-col>
      </b-row>
      <b-button class="saveUser" variant="success" v-on:click="save(user)">Salvar</b-button>
    </b-form>
  </div>
</template>
​
<script>
import userService from "@/services/user.service.js"
import { required, email } from "vuelidate/lib/validators";

export default {
  name: "User",
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
  computed:{
    nameState(){
      while(this.user.name === ""){
        //debugger;
        return false;
      }

    }
  },
  methods: {
    save: (user) => {
      //e.preventDefault();
      
      
      userService.save(user)
    }
  }
}
</script>
<style scoped>
.user{
  text-align: justify;
  background-color: white;
}
</style>