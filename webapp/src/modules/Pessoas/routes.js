import Question from '@/components/Question.vue'
import Home from '@/views/Home.vue'


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
 
]