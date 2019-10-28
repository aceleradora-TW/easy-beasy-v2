<template>
  <div>
      <b-input v-model="$data.user.name"></b-input>
      <b-input v-model="$data.user.email"></b-input>
      <b-button v-on:click="addUser()">Enviar</b-button>
  </div>
</template>

<script>

import userService from '@/services/user.service.js'

export default {
    name:"User",
    data: ()=> ({
        user: {    
            name: "", 
            email: ""        
        }
    }),
    methods:{
        addUser:()=> {
            debugger;
            userService.addUser(this.user);
        }  
    }
      
}
</script>

<style scoped>
</style>
