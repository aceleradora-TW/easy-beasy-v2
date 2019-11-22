import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex'
import Vuelidate from "vuelidate"
import Eventbus from './utils/eventbus'
import icons from './utils/icons'
import BootstrapVue from 'bootstrap-vue'
import store from './store/'
import router from './router'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueAnalytics from 'vue-analytics'
import './assets/scss/config/vendors.scss'

Vue.config.productionTip = false

const isPord = process.env.NODE_ENV === 'production'

Vue.use(VueAnalytics, {
    id: 'UA-152951201-1',
    router,
    debug:{
        enabled: !isPord,
        sendHitTask: isPord
    }
})

Vue.use(Vuex)
Vue.use(icons)
Vue.use(BootstrapVue)
Vue.use(Eventbus)
Vue.use(Vuelidate);

new Vue({
    router,
    store,
    render: h => h(App),
}).$mount('#app')