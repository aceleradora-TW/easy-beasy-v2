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

const isProd = process.env.NODE_ENV === 'production'
const googleAnalyticsId = process.env.EASY_BEASY_GOOGLE_ANALYTICS_ID

Vue.use(VueAnalytics, {
    id: googleAnalyticsId,
    router,
    debug: {
        enabled: !isProd,
        sendHitTask: isProd
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