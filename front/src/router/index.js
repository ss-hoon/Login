import Vue from 'vue'
import VueRouter from 'vue-router'

import WebRouter from './modules/index.js'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: WebRouter
})

export default router
