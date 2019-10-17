import http from '../utils/http'
const handle = (promise) => {
   return promise
     .then(data => ([data, undefined]))
     .catch(error => Promise.resolve([undefined, error]));
 }
export default {
   getAll : async () => {
      let [data, Err] = await handle(http.get('/testeum/'));
      if(Err) throw new Error('Could not fetch data', Err);
      return data;
   }

}
