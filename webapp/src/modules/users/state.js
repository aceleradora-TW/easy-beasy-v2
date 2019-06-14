const state = {
    usersList: [],
}

const mutations = {
    'USERS_SET_LIST' (state, obj) {
        state.usersList = obj.users
    },
}

export default {
    state, mutations
}