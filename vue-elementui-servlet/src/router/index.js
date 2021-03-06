import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Student from "../views/Student";
import Classes from "../views/Classes";
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    children:[
      {
        path: '/student',
        name: 'Student',
        component: Student
      },
      {
        path: '/classes',
        name: 'Classes',
        component: Classes
      },
    ]
  },

]

const router = new VueRouter({
  routes
})

export default router
