<template>
  <div class="user">
    <b-form>
      <input type="hidden"/>
      <b-row>
          <b-col md="6" sm="12">
            <b-form-group label-for="user-name">
              <b-form-input id="user-name" type="text" v-model="user.name" required placeholder="Informe seu nome"/>
            </b-form-group>
          </b-col>
      </b-row>
      <input type="hidden"/>
      <b-row>
          <b-col md="6" sm="12">
            <b-form-group label-for="user-email">
              <b-form-input id="user-email" type="email" v-model="user.email" required placeholder="exemplo@gmail.com"/>
              <div v-if="!v.required">Email is required</div>            
            </b-form-group>
          </b-col>
      </b-row>
      <b-button class="saveUser" variant="success" v-on:click="submit">Salvar</b-button>
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
    }
  }),
   validations: {
    user: {
      name: { required },
      email: { required, email }
    }
  },
  methods: {
    save: (user) => {
      userService.save(user)
    },
    submit() {
      this.$v.form.$touch();
      // if its still pending or an error is returned do not submit
      alert("Form submitted");
      if (this.$v.form.$pending || this.$v.form.$error) return;
      // to form submit after this
    }
    
  }
}
</script>
​
<style scoped>
.user{
  background-color: white;
}
.saveUser{

}
</style>