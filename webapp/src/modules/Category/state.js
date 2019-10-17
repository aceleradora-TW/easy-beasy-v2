const state = {
    list: [],
}

const mutations = {
    'ADD_CATEGORIES' (state, obj) {
        state.list.push(obj);
    },
}

export default {
    state, mutations
}