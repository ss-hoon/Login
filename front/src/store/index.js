import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo: {
      userId: "",
      userPwd: ""
    }
  },
  getters: {
    getUserId: state => {
      return state.userInfo.userId;
    },
    getUserPwd: state => {
      return state.userInfo.userPwd;
    }
  },
  mutations: {
    setUserId: (state, payload) => {
      state.userInfo.userId = payload;
    },
    setUserPwd: (state, payload) => {
      state.userInfo.userPwd = payload;
    }
  },
  actions: {
    setUserId: ({ commit }, payload) => {
      commit("setUserId", payload);
    },
    setUserPwd: ({ commit }, payload) => {
      commit("setUserPwd", payload);
    }
  }
})
