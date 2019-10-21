import Home from '@/components/Home.vue'
import UserDetails from '@/components/UserDetails.vue'

export default [
    {
        name: 'users.index',
        path: '/home',
        component: Home,
        children: []
    },
    {
        name: 'users.details',
        path: '/details',
        component: UserDetails,
        children: []
    },
]
