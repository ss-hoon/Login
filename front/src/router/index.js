import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '@/views/Login.vue')
  },
  {
    path: '/main',
    name: 'Main',
    component: () => import(/* webpackChunkName: "about" */ '../views/Main.vue')
  },
  {
    path: '/searchId',
    name: 'SearchId',
    component: () => import(/* webpackChunkName: "about" */ '../views/SearchId.vue')
  },
  {
    path: '/searchPwd',
    name: 'SearchPwd',
    component: () => import(/* webpackChunkName: "about" */ '../views/SearchPwd.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
