import http from '../utils/request'

export default {
  getPessoas : ()   => http.get(`/testeum/`),
  getPessoa  : (id) => http.get(`/pessoas/${id}`)
  
}

