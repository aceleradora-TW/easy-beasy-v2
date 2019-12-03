<template>
  <div class="background">
    <b-col>
      <h3 class="header">Cadastro do Administrador</h3>
    </b-col>

    <b-form>
      <b-col>
        <b-form-group
          label="Nome do usuário:"
          label-for="input-2"
          class="format"
        >
          <b-form-input v-model="form.name" required></b-form-input>
        </b-form-group>
      </b-col>

      <b-col>
        <b-form-group label="Senha:" label-for="input-3" class="format">
          <b-form-input
            id="input-3"
            v-model="form.password"
            type="password"
            required
          ></b-form-input>
        </b-form-group>
      </b-col>

      <b-button class="btn" type="submit" v-on:click="save()">Acessar</b-button>
    </b-form>
  </div>
</template>

<script>
import administratorService from "@/services/administrator.service";

export default {
  data:() => ({
    form: {
      username: "",
      password: ""
      }
  }),
  methods: {
    save () {
      administratorService.save(this.form).then(() => {
        alert("Cadastrado com sucesso")
      }).catch(errors => console.log(errors));
    }

  }
};
</script>

<style lang="scss" scoped>
@import "@/assets/scss/config/variables.scss";
.btn {
  background-color: $primary-color;
  border-color: $primary-color;
  font-family: $primary-font-family;
}
.header {
  color: $primary-color;
  font-family: $primary-font-family;
}
.mt-20 {
  margin-top: 20px;
  font-family: $primary-font-family;
}
.format {
  width: 300px;
}
</style>
