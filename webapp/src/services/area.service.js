import http from '../utils/http.js'

export default {
    getAreas: () => http.get('/area')
}