//组织人员路由
//引入组件
import lookGroup from '../module/personnel_group/look_group';
import lookDepGroup from '../module/personnel_group/look_dep_group';
import editGroup from '../module/personnel_group/edit_group';
import addGroup from '../module/personnel_group/add_group';
//配置路由
const routes = [{
    path: '/lookGroup/:id',
    name: 'lookGroup',
    component: lookGroup
}, {
    path: '/lookDepGroup/:id',
    name: 'lookDepGroup',
    component: lookDepGroup
}, {
    path: '/editGroup/:id',
    name: 'editGroup',
    component: editGroup
}, {
    path: '/addGroup/:id',
    name: 'addGroup',
    component: addGroup
}];
//导出路由配置信息
export default {
    routes
};