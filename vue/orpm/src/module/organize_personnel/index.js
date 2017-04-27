// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import Index from '@/module/organize_personnel/main';
//为zTree提供的，vue自带jquery常用功能，所以建议不要在其他地方使用jquery
import $ from 'jquery';
//引入路由信息
import routerObj from '../../router/org_per.js';
//全局引入公用的ui框架
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-default/index.css';
Vue.use(ElementUI);
//引入公用的样式
// import './assets/css/common.css';
//关闭生产模式下给出的提示 
Vue.config.productionTip = false;
//非父子组件之间的通信公用的状态管理对象
// var bus = new Vue()
// import bus from '../../status.js'
// bus.$on('addDep', function (id) {
//   that.rightComponent = "addDep"
// })
// bus.$on('editDep', function (id) {
//   that.rightComponent = "editDep"
// })
//引入状态管理器
import store from '../../vuex/store.js';
// import Vuex from 'vuex'
// Vue.use(Vuex)
//store为实例化生成的
/*const store = new Vuex.Store({
  state:{
    treeNode: null
  }
});*/
// import store from '../../store'
//引入路由
import VueRouter from 'vue-router';
Vue.use(VueRouter);
//引入vue-resource
import VueResource from 'vue-resource';
Vue.use(VueResource);
//配置路由
const router = new VueRouter({
    routes: routerObj.routes // （缩写）相当于 routes: routes
});
console.log("index_1111");
/* eslint-disable no-new */
new Vue({
    router,
    store,
    el: '#orgPer',
    template: '<Index/>',
    components: {
        Index
    }
});