//组织人员路由
//引入组件
import lookDep from '../module/organize_personnel/look_dep';
import lookEmp from '../module/organize_personnel/look_emp';
import addDep from '../module/organize_personnel/add_dep';
import editDep from '../module/organize_personnel/edit_dep';
import addEmp from '../module/organize_personnel/add_emp';
import editEmp from '../module/organize_personnel/edit_emp';
//配置路由
const routes = [{
        path: '/lookDep/:id',
        name: 'lookDep',
        component: lookDep
    }, {
        path: '/lookEmp/:id',
        name: 'lookEmp',
        component: lookEmp
    }, {
        path: '/addDep/:id',
        name: 'addDep',
        component: addDep
    }, {
        path: '/editDep/:id',
        name: 'editDep',
        component: editDep
    }, {
        path: '/addEmp/:id',
        name: 'addEmp',
        component: addEmp
    }, {
        path: '/editEmp/:id',
        name: 'editEmp',
        component: editEmp
    }]
    //导出路由配置信息
export default {
    routes
}