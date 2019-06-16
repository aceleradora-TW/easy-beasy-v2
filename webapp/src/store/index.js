import Vue from 'vue'
import Vuex from 'vuex'
import state from './state'
import mutations from './mutations'
import pessoas from '../modules/Pessoas/state'

Vue.use(Vuex)

export default new Vuex.Store({
    state,
    mutations,
    modules: { pessoas }
})