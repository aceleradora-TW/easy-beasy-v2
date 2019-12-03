<template>
  <div>

    <b-col>
      <p>Cabeçalho</p>
    </b-col>

    <b-form @submit="onSubmit">
      <b-col>
        <b-form-group id="input-group-1" label="Email:" label-for="input-1">
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
        <b-form-group
          id="input-group-2"
          label="Nome do usuário:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="form.name"
            required
          ></b-form-input>
        </b-form-group>
      </b-col>

      <b-col>
        <b-form-group id="input-group-3" label="Senha:" label-for="input-2">
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
</style>
