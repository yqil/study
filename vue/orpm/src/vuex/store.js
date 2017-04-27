import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);
export default new Vuex.Store({
    state: {
        treeNode: null,
        postionTreeNode: null,
        refreshGroupTreeNode: null,
        initSelectedEmployeeInfo: null,
        selectedEmployeeInfo: []
    },
    mutations: {
        CHANGE_TREE_NODE: function(state, value) {
            state.treeNode = value;
        },
        CHANGE_POSTION_TREE_NODE: function(state, value) {
            state.postionTreeNode = value;
        },
        CHANGE_GROUP_TREE_NODE: function(state, value) {
            state.refreshGroupTreeNode = value;
        },
        CHANGE_SELECTED_EMPLOYEE_INFO: function(state, value) {
            state.selectedEmployeeInfo = value;
        },
        CHANGE_INIT_SELECTED_EMPLOYEE_INFO: function(state, value) {
            state.initSelectedEmployeeInfo = value;
        }
    },
    actions: {
        changeTreeNode: function({
            commit
        }, value) {
            commit("CHANGE_TREE_NODE", value)
        },
        changePostionTreeNode: function({
            commit
        }, value) {
            commit("CHANGE_POSTION_TREE_NODE", value)
        },
        changeGroupTreeNode: function({
            commit
        }, value) {
            commit("CHANGE_GROUP_TREE_NODE", value)
        },
        changeSelectedEmplyeeInfo: function({
            commit
        }, value) {
            commit("CHANGE_SELECTED_EMPLOYEE_INFO", value)
        },
        changeInitSelectedEmplyeeInfo: function({
            commit
        }, value) {
            commit("CHANGE_INIT_SELECTED_EMPLOYEE_INFO", value)
        }
    },
    getters: {
        getTreeNode: function(state) {
            return state.treeNode
        },
        getPostionTreeNode: function(state) {
            return state.postionTreeNode
        },
        getGroupTreeNode: function(state) {
            return state.refreshGroupTreeNode
        },
        getSelectedEmplyeeInfo: function(state) {
            return state.selectedEmployeeInfo
        },
        getInitSelectedEmplyeeInfo: function(state) {
            return state.initSelectedEmployeeInfo
        }
    }
});