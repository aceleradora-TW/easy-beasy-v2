import http from '../utils/http.js'
export default{
    getStagesList: () => http.get('/stage')
}