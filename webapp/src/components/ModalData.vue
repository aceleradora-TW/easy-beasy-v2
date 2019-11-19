<template>
  <div>
    <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modalData">
      <p>
        <strong>Por favor, nos informe nome e email para receber o diagnóstico.</strong>
      </p>
      <b-form>
        <b-row>
          <b-col md="6" sm="12">
            <b-form-group label-for="user-name">
              <b-form-input
                id="user-name"
                name="user-name"
                v-model="$v.user.name.$model"
                :state="$v.user.name.$dirty ? !$v.user.name.$error : null"
                placeholder="Informe seu nome"
              />
              </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col md="6" sm="12">
            <b-form-group label-for="user-email">
              <b-form-input
                id="user-email"
                type="email"
                v-model="$v.user.email.$model"
                :class="{ 'is-invalid': save && $v.user.email.$error }"
                placeholder="exemplo@gmail.com"
              />
            </b-form-group>
          </b-col>
        </b-row>
        <b-container fluid>
          <b-row class="mb-3">
            <b-col md="1.5" class="ml-md-auto">
              <b-button
                squared
                type="submit"
                v-on:click="save(), $bvModal.hide('modalData')"
                class="saveUser answer-btn mt-20" @click="toast('b-toaster-top-center')"
                :disabled="$v.user.$invalid"
              >Salvar</b-button>
            </b-col>
          </b-row>
        </b-container>
      </b-form>
    </b-modal>
  </div>
</template>


<script>
import userService from "@/services/user.service";
import { required, email } from "vuelidate/lib/validators";

export default {
  name: "ModalData",
   props: {
    callBack: { type: Function },
  },
  data: () => ({
    user: {
      name: "",
      email: ""
    }
  }),
  validations: {
    user: {
      name: {
        required
      },
      email: {
        required, email
      }
    }
  },
  methods: {
    toast(toaster) {
    this.$bvToast.toast(`Salvo com Sucesso`, {
      title: `EasyBeasy`,
      toaster
    })
},
    save() {
      this.$v.user.$touch()
        if (this.$v.user.$anyError) {
        return
      }
      userService.save(this.user).then(/*somente sucesso*/() => {
                this.callBack();
      }).catch(/*todos os erros*/errors => console.log(errors));

    }
  }
};


</script>
<style lang="scss" scoped>
@import '@/assets/scss/config/variables.scss';
.user {
  text-align: justify;
  background-color: white;
}
.answer-btn {
  background-color: $primary-color;
  border-color:$primary-color;
}
.answer-btn:hover{
  background-color:$primary-color;
  border-color:$primary-color;
}
.mt-20{
  margin-top: 20px;
}
</style>