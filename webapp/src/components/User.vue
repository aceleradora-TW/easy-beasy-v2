<template>
  <div>
      <b-input v-model="$data.user.name"></b-input>
      <b-input v-model="$data.user.email"></b-input>
      <b-button v-on:click="save($data.user)">Enviar</b-button>
  </div>
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
        debugger;
        userService.save(user)
                        .then(response => alert("Usuário salvo com sucesso!"))
                        .catch(error => alert("Algo deu errado!"))
        }
    }
}
</script>
​
<style scoped>
</style>