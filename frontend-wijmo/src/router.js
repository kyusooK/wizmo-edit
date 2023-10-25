
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CompanyManager from "./components/ui/CompanyGrid"
import ProductManager from "./components/ui/ProductGrid"
import Manager from "./components/ui/Grid"

import InventoryManager from "./components/ui/InventoryGrid"

import SalesOrderManager from "./components/ui/SalesOrderGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/companies',
                name: 'CompanyManager',
                component: CompanyManager
            },
            {
                path: '/products',
                name: 'ProductManager',
                component: ProductManager
            },
            {
                path: '/',
                name: 'Manager',
                component: Manager
            },

            {
                path: '/inventories',
                name: 'InventoryManager',
                component: InventoryManager
            },

            {
                path: '/salesOrders',
                name: 'SalesOrderManager',
                component: SalesOrderManager
            },



    ]
})
