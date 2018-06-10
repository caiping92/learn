// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import iView from 'iview'     //引入iView
import 'iview/dist/styles/iview.css';    // 使用 CSS
import './styles/my-theme/index.less';

//
import ECharts from 'vue-echarts/components/ECharts.vue'
import  'echarts'
// import ECharts modules manually to reduce bundle size
// import 'echarts/lib/chart/bar'
// import 'echarts/lib/component/tooltip'
// import 'echarts/lib/component/markLine'
// import 'echarts/lib/component/legend'
// import 'echarts/lib/component/toolbox'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.component('chart', ECharts)
Vue.use(iView);
Vue.config.productionTip = false
Vue.use(BootstrapVue);  //使用Bootstrap

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {App}
})
