import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

// Mutations names
export const SET_AUTHTOKEN = "setKey";
export const SET_USERNAME = "setUsername";

export let store = new Vuex.Store({
    state: {
        authToken: "",
        username: "",
    },

    getters: {},

    mutations: {
        [SET_AUTHTOKEN](state, authToken) {
            this.state.authToken = authToken
        },
        [SET_USERNAME](state, event) {
            this.state.username = event.target.value
        }
    }
});
