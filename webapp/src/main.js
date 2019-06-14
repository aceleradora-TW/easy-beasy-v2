import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex'
import Eventbus from './utils/eventbus'
import icons from './utils/icons'
import BootstrapVue from 'bootstrap-vue'
import store from './store/'
import router from './router'

import './assets/scss/config/vendors.scss'

Vue.config.productionTip = false
Vue.use(Vuex)
Vue.use(icons)
Vue.use(BootstrapVue)
Vue.use(Eventbus)

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
