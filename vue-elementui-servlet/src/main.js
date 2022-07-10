import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Axios from "axios";


Vue.config.productionTip = false
Vue.use(ElementUI);

//代表每个vue实例都可以使用axios进行后台访问
Vue.prototype.axios = Axios;

//代表在所有请求前添加/api路径
Axios.defaults.baseURL = "/api"
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
