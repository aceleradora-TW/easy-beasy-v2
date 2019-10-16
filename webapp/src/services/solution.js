export default {
  solution: () => {
    let solution = "";
    request.get(`/solution/`).then(response => {
      solution = response.data.solution})
      .catch((error)=>{
        console.log(erro)
      })
      return solution;
  }
}