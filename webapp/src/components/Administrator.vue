<template>
  <div class="background">
    <b-col>
      <h3 class="header">Cadastro do Administrador</h3>
    </b-col>

    <b-form @submit="onSubmit">
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
        <b-form-group id="input-group-1" label="Email:" label-for="input-1" class="format">
          <b-form-input
            id="input-1"
            v-model="form.email"
            type="email"
            required
            placeholder="exemplo@email.com"
          ></b-form-input>
        </b-form-group>
      </b-col>

      <b-col>
        <b-form-group label="Senha:" label-for="input-3" class="format">
          <b-form-input
            id="input-3"
            v-model="form.password"
            required
          ></b-form-input>
        </b-form-group>
      </b-col>

      <b-button class="btn" type="submit">Acessar</b-button>
    </b-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        email: "",
        name: ""
      }
    };
  },
  methods: {}
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
