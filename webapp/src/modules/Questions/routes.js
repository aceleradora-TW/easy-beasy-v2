import Question from '@/components/Question.vue'
import Home from '@/views/Home.vue'
export default [{
        name: 'questions.index',
        path: '/questions',
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