import Vue from 'vue'
import Router from 'vue-router'
import axios from 'axios'
import category from './modules/Category/routes'
import store from './store/'

Vue.use(Router)

const routes = [].concat(category)

const router = new Router({
  mode: 'history',
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
