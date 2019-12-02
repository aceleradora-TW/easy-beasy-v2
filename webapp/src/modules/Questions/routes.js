import Question from '@/components/Question.vue'
import Home from '@/views/Home.vue'
import ViewQuestions from '@/components/ViewQuestions'

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
        name: 'questions.index',
        path: '/visualizarPerguntas',
        component: ViewQuestions,
        children: []

    },

]