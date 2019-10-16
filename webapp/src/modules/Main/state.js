const state = {
    list: [],
}

const mutations = {
    'PESSOAS_SET_LIST' (state, obj) {
        state.list.push(obj);
    },
}

export default {
    state, mutations
}