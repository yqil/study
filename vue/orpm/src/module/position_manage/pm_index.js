// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import Index from '@/module/position_manage/main';
//为zTree提供的，vue自带jquery常用功能，所以建议不要在其他地方使用jquery
import $ from 'jquery';
//引入路由信息
import routerObj from '../../router/position_manage.js';
//全局引入公用的ui框架
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-default/index.css';
Vue.use(ElementUI);
//引入公用的样式
// import './assets/css/common.css';
//关闭生产模式下给出的提示 
Vue.config.productionTip = false;
//引入状态管理器
import store from '../../vuex/store.js';
//引入路由
import VueRouter from 'vue-router';
Vue.use(VueRouter);
//引入vue-resource
import VueResource from 'vue-resource';
Vue.use(VueResource);
//配置路由
const router = new VueRouter({
    routes: routerObj.routes
});
console.log("index_3333");
/* eslint-disable no-new */
new Vue({
    router,
    store,
    el: '#posManage',
    template: '<Index/>',
    components: {
        Index
    }
});