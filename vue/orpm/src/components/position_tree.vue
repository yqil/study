<!-- 部门职位树结构组件 -->
<template>
  <div>
    <div class="pt-search">
      <el-input placeholder="请输入搜索条件" icon="search" v-model="searchContent" :on-icon-click="searchTree"> </el-input>
    </div>
    <ul id="positionTree" class="ztree"></ul>
  </div>
</template>

<script>
import '../assets/ztree/jquery.ztree.core.min.js'
import {mapGetters} from 'vuex'

export default {
  name: 'positionTree',
  data: function(){
    return {
        searchContent: null,
        treeData: null,
        searchNodes: [],
        treeObj: null
    }
  },
  computed: mapGetters(['getPostionTreeNode']),
  watch: {
    getPostionTreeNode: function(val){
      this.initPosTree();
    }
  },
  mounted: function(){
    this.initPosTree();
    
  },
  methods: {
    initTreeSettings: function(){
      var that = this;
      return {
        data: {
          simpleData: {
            enable: true
          }
        },
        callback: {
          onClick: function(event, treeId, treeNode, clickFlag){
            if(treeNode.type === 1){
              that.$router.push({name: 'lookDep', params: {id: treeNode.id}});
            }else if(treeNode.type === 2){
              that.$router.push({name: 'lookPos', params: {id: treeNode.id}});
            }
          }
        }
      };
    },
    searchTree: function(){
        var treeObj = $.fn.zTree.getZTreeObj("positionTree");
        // treeObj.setting = 
        // this.treeData
        this.searchNodes = [];
        // this.treeObj.updateNode(this.treeData);
        $.fn.zTree.init($("#positionTree"), this.initTreeSettings(), this.treeData);
        var nodes = treeObj.getNodesByParamFuzzy("name", this.searchContent, null);
        // this.treeObj.updateNode(nodes);
        /*for(var i = 0; i < nodes.length; i++){
          console.log(nodes[i].name);
          this.findParentNode(treeObj,nodes[i]);
          // treeObj.expandNode(nodes[i].getParentNode(), true, false, false);
        }*/
        // debugger;
        // this.treeObj.updateNode(this.searchNodes);
        // $.fn.zTree.init($("#positionTree"), this.initTreeSettings(), nodes);
        // debugger;
        $.fn.zTree.init($("#positionTree"), this.initTreeSettings(), nodes);
    },
    findParentNode: function(treeObj,node){
      // nodes[i].getParentNode()
      if(node && node.pId === 1){
        return;
      }else if(node){
          this.searchNodes[this.searchNodes.length] = node;
          if(node.pId){
            node = this.treeObj.getNodesByParamFuzzy("id", node.pId, null)[0]
            this.findParentNode(treeObj,node);
          }
      }
    },
    initPosTree: function(){
      var that = this;
      this.$http.get('/orpm/getDepAndPositionTree.do?id=1').then(function(response) {
        if(response && response.body && response.body.status === 0){
          var zNodes = response.data.data;
          if(zNodes && zNodes.length > 0){
            zNodes[0].open = true;
            zNodes[0].iconOpen = "/static/ztree/img/company.gif";
            zNodes[0].iconClose = "/static/ztree/img/company.gif";
            for(var i = 1; i < zNodes.length; i++){
              if(zNodes[i].type === 1){
                zNodes[i].icon = "/static/ztree/img/company.gif";
              }else if(zNodes[i].type === 2){
                zNodes[i].icon = "/static/ztree/img/employee.gif";
              }
            }
            that.treeData = zNodes;
            that.treeObj = $.fn.zTree.init($("#positionTree"), that.initTreeSettings(), zNodes);
          }
        }else if(response && response.body && response.body.status !== 0){
          this.showErrNotification("错误提示", response.data.msg);
        }else {
          this.showErrNotification("错误提示", "系统出现异常");
        }
      }, function(response) {
        this.showErrNotification("错误提示", "初始化部门树失败");
      });
    },
    showErrNotification(title, msg) {
      this.$notify.error({
        title: title,
        message: msg
      });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  @import '/static/ztree/zTreeStyle.css';

  .pt-search{
    margin-top: 5px;
    padding: 5px;
    border-bottom: 2px dotted #ccc;
  }
</style>
