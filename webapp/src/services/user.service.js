import http from '../utils/http'

export default {
    save: (user) => http.post(`/user/`, user)
}