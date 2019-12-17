<template>
  <div>
    <b-modal hide-header-close hide-footer no-close-on-backdrop no-close-on-esc id="modalData"
    title="Queremos conhecer você!"
    :header-bg-variant = "headerBgVariant"
    :header-text-variant = "headerTextVariant">
        <p class="mt-20">
          {{user.collectText}}
        </p>
      <b-row>
        <b-col md="6" sm="12">
          <b-form-group label-for="user-name">
            <b-form-input
              class="mt-20"
              id="user-name"
              type="text"
              v-model.trim="$v.user.name.$model"
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
              class="mt-20"
              id="user-email"
              type="email"
              v-model.trim="$v.user.email.$model"
              :state="$v.user.email.$dirty ? !$v.user.email.$error : null"
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
              class="saveUser answer-btn mt-20"
              :disabled="$v.user.$invalid"
            >Salvar</b-button>
          </b-col>
        </b-row>
      </b-container>
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
      email: "",
      collectText:"Chegamos a um resultado, informe seus dados para que possamos compartilha-lo com você."
    },
    headerBgVariant: 'info',
    headerTextVariant: 'light'
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
    save() {
      this.$v.user.$touch()
        if (this.$v.user.$anyError) {
        return
      }
      userService.save(this.user).then(() => {
                this.callBack();
      }).catch(errors => console.log(errors));

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
        font-family: $primary-font-family;
    }
</style>