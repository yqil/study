<!-- 选择部门或员工组件 -->
<template>
  <div>
   <ul id="treeDemo" class="ztree"></ul>
  </div>
</template>

<script>
import '../assets/ztree/jquery.ztree.core.min.js'
import {mapGetters} from 'vuex'

export default {
  name: 'deptree',
  computed: mapGetters(['getTreeNode']),
  watch: {
    getTreeNode: function(val){
      this.initDepTree();
    }
  },
  mounted: function(){
    this.initDepTree();
    /*this.$http.get('/orpm/getDepTree').then(function(response) {
      var zNodes = response.body.data;
      if(zNodes && zNodes.length > 0){
        $(document).ready(function(){
          $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
      }
    }, function(response) {
      // error callback
    });*/
    
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
              that.$router.push({name: 'lookEmp', params: {id: treeNode.id}});
            }
          }
        }
      };
    },
    initDepTree: function(){
      var that = this;
      this.$http.get('/orpm/getDepAndEmployTree.do?id=1').then(function(response) {
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
            $.fn.zTree.init($("#treeDemo"), that.initTreeSettings(), zNodes);
          }
        }else if(response && response.body && response.body.status !== 0){
          this.showErrNotification("错误提示", response.data.msg);
        }else {
          this.showErrNotification("错误提示", "系统出现异常");
        }
      }, function(response) {
        // error callback
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
</style>
