import http from '../utils/http'

export default {
   getPessoas : ()   => http.get(`/pessoas/`),
   getPessoa  : (id) => http.get(`/pessoas/${id}`)

}

