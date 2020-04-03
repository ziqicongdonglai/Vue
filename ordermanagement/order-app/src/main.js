import Vue from 'vue'
import App from './App.vue'
import router from './router'
//导入axios
import axios from 'axios'
import VueAxios from 'vue-axios'
// 导入element-ui组件库
import ElementUI from 'element-ui'
//导入组件相关样式
import 'element-ui/lib/theme-chalk/index.css'

//use
Vue.use(VueAxios, axios)

//配置vue插件
Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
