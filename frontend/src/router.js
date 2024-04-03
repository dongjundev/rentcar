
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReserveReserveManager from "./components/listers/ReserveReserveCards"
import ReserveReserveDetail from "./components/listers/ReserveReserveDetail"

import CarCarManager from "./components/listers/CarCarCards"
import CarCarDetail from "./components/listers/CarCarDetail"

import NotificationMessageManager from "./components/listers/NotificationMessageCards"
import NotificationMessageDetail from "./components/listers/NotificationMessageDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reserves/reserves',
                name: 'ReserveReserveManager',
                component: ReserveReserveManager
            },
            {
                path: '/reserves/reserves/:id',
                name: 'ReserveReserveDetail',
                component: ReserveReserveDetail
            },

            {
                path: '/cars/cars',
                name: 'CarCarManager',
                component: CarCarManager
            },
            {
                path: '/cars/cars/:id',
                name: 'CarCarDetail',
                component: CarCarDetail
            },

            {
                path: '/notifications/messages',
                name: 'NotificationMessageManager',
                component: NotificationMessageManager
            },
            {
                path: '/notifications/messages/:id',
                name: 'NotificationMessageDetail',
                component: NotificationMessageDetail
            },




    ]
})
