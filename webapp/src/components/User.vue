<template>
  <b-container>
    <b-row>
      <b-input v-model="$data.user.name"></b-input>
      <b-input v-model="$data.user.email"></b-input>
      <b-button v-on:click="save($data.user)">Enviar</b-button>
    </b-row>
  </b-container>
</template>
​
<script>
import userService from "@/services/user.service.js"

export default {
  name: "User",
  data: () => ({
    user: {
      name: "",
      email: ""
    }
  }),
  methods: {
    save: (user) => {
      userService.save(user)
        .then(response => alert(`Usuário salvo com sucesso! ${response.status}`))
        .catch(error => alert(`Algo deu errado! ${error}`))
    }
  }
}
</script>
​
<style scoped>
</style>