import Vue from 'vue'
import Router from 'vue-router'
import axios from 'axios'
import store from './store/'
import question from './modules/Questions/routes'
import registerQuestions from './modules/RegisterQuestions/routes'


Vue.use(Router)

const routes = [].concat(question, registerQuestions)


const router = new Router({
    routes
})

router.beforeEach((to, from, next) => {
    const token = store.state.token
    if (token) {
        axios.defaults.headers.common['Authorization'] = `Bearer: ${token}`
        next()
    } else {
        if (to.name !== 'login.index' && store.state === '') {
            next({ name: 'login.index' })
        }
        next()
    }
})

export default router