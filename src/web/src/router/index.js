import Vue from 'vue'
import Router from 'vue-router'
import Index from '../components/Index'
import Grid from '../components/GridTest'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/grid',
      name: 'grid',
      component: Grid
    }
  ]
})
