import http from '../utils/http'

export default {
    addUser: (user) => http.post(`/user/`, user)
        .then(response => alert('salvo com sucesso'))
        .catch(error => alert('ocorreu um erro'))

}