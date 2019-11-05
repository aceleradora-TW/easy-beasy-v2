import Question from '@/components/Question.vue'
import Home from '@/views/Home.vue'
import UserDetails from '@/components/UserDetails.vue'
import Solution from '@/components/Solutions.vue'


export default [{
        name: 'users.question',
        path: '/',
        component: Question,
        children: []
    },
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