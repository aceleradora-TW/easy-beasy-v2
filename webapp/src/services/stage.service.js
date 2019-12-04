import http from "../utils/http.js";

export default {
  getStages: () => http.get("/stage"),
  getStageById: id => http.get(`/stage/${id}`)
};
