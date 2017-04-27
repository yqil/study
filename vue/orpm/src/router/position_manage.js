//组织人员路由
//引入组件
import lookDep from '../module/position_manage/look_dep';
import lookPos from '../module/position_manage/look_pos';
import addPos from '../module/position_manage/add_pos';
import editPos from '../module/position_manage/edit_pos';
//配置路由
const routes = [{
    path: '/lookDep/:id',
    name: 'lookDep',
    component: lookDep
}, {
    path: '/lookPos/:id',
    name: 'lookPos',
    component: lookPos
}, {
    path: '/addPos/:id',
    name: 'addPos',
    component: addPos
}, {
    path: '/editPos/:id',
    name: 'editPos',
    component: editPos
}];
//导出路由配置信息
export default {
    routes
}