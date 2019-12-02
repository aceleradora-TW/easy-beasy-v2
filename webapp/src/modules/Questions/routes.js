import Question from '@/components/Question.vue'
import Home from '@/views/Home.vue'
import Administrator from '@/views/Administrator.vue'
export default [
    {
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
    {
        name: 'Administrator.index',
        path: '/administrador',
        component: Administrator,
        children: []
    },
]