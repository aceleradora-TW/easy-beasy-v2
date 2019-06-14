import axios from 'axios'

export default {
    'SET_TOKEN' (state, obj) {
        axios.defaults.headers.common['Authorization'] = `Bearer: ${obj.token}`
        state.token = obj.token
    },
    'SET_USER' (state, obj) {
        state.user = obj.user
    }
}