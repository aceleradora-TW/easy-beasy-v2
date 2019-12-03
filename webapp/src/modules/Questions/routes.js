import Home from '@/views/Home.vue'
import Administrator from '@/views/Administrator.vue'
export default [
    {
        name: 'users.index',
        path: '/',
        component: Home,
        children: []
    },
    {
        name: 'Administrator.index',
        path: '/administrador',
        component: Administrator,
        children: []
    },
]