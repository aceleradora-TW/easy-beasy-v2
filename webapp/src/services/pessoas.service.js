import request from '../utils/request';

export default {
  getPessoas : ()   => request.get(`/testeum/`),
  getPessoa  : (id) => request.get(`/pessoas/${id}`),
}