export default {
  solution: (index) => {
    let solution = "";
    request.get(`/solution/${index}`).then(response => {
      solution = response.data.solution})
      .catch((error)=>{
        //tratar erro
      })
      return solution;
  }
}