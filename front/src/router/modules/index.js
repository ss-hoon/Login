import ApiRouter from '@router/modules/api/index.js'
import ViewRouter from '@router/modules/views/index.js'

export default [
    {
        path: '/',
        component: () => import('@views/index.vue'),
        children: ViewRouter
    },
    {
        path: '/api',
        component: () => import('@api/index.vue'),
        children: ApiRouter
    }
]
    