import Home from '@/views/Home.vue'
import UserDetails from '@/components/UserDetails.vue'
import Solution from '@/modules/Solutions/Solutions.vue'


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
    {
        name: 'users.solutions',
        path: '/solutions',
        component: Solution,
        children: []
    }
]