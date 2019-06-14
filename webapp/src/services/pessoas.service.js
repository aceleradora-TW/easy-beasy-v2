import http from './http'

export default {
   getPessoas : ()   => http.get(`/pessoas/`),
   getPessoa  : (id) => http.get(`/pessoas/${id}`)

}

