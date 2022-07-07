export default [
    {
        path: '/',
        name: 'Login',
        component: () => import('@views/Login.vue')
    },
    {
        path: '/main',
        name: 'Main',
        component: () => import('@views/Main.vue')
    },
    {
        path: '/searchId',
        name: 'SearchId',
        component: () => import('@views/SearchId.vue')
    },
    {
        path: '/searchPwd',
        name: 'SearchPwd',
        component: () => import('@views/SearchPwd.vue')
    }
]