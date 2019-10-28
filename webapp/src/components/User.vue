<template>
  <div>
      <b-input v-model="$data.user.name"></b-input>
      <b-input v-model="$data.user.email"></b-input>
      <b-button v-on:click="save($data.user)">Enviar</b-button>
  </div>
</template>
​
<script>
​
import userService from "@/services/user.service.js"
​
export default {
    name:"User",
     data: () => ({
        user: {
            name: '',
            email: ''
        }
    }),
    methods:{
        save:(user)=> {
            userService.save(user)
                       .then(response => alert('salvo com sucesso'))
                       .catch(error => alert('ocorreu um erro'));
        }  
    }
      
}
</script>
​
<style scoped>
</style>