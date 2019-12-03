import Home from '@/views/Home.vue'
import ViewQuestions from '@/components/ViewQuestions'

export default [
    {
        name: 'users.index',
        path: '/',
        component: Home,
        children: []
    },
    {
        name: 'questions.index',
        path: '/visualizarPerguntas',
        component: ViewQuestions,
        children: []
    }
]