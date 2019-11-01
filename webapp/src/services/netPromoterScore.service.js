import http from '@/utils/http'

export default {
  save: (score) => http.post(`/net-promoter-score`, score)
}
