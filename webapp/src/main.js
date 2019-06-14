import Vue from 'vue'
import App from './App.vue'
import icons from './utils/icons'
import BootstrapVue from 'bootstrap-vue'
import './assets/scss/config/vendors.scss'

Vue.config.productionTip = false
Vue.use(icons)
Vue.use(BootstrapVue)
new Vue({
  render: h => h(App),
}).$mount('#app')
