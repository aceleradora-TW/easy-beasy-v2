import http from '../utils/http';

export default {
  getPessoas : ()   => http.get(`/testeum/`),
  getPessoa  : (id) => http.get(`/pessoas/${id}`),
}