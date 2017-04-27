<!-- 部门树结构前端组件 -->
<template>
  <div>
   <ul id="groupTree" class="ztree"></ul>
  </div>
</template>

<script>
import '../assets/ztree/jquery.ztree.core.min.js'
import {mapGetters} from 'vuex'

export default {
  name: 'grouptree',
  computed: mapGetters(['getGroupTreeNode']),
  watch: {
    getGroupTreeNode: function(val){
      this.initDepTree();
    }
  },
  mounted: function(){
    this.initDepTree();
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
              that.$router.push({name: 'lookDepGroup', params: {id: treeNode.id}});
            }else {
              that.$router.push({name: 'lookGroup', params: {id: treeNode.id}});
            }
          }
        }
      };
    },
    initDepTree: function(){
      var that = this;
      this.$http.get('/orpm/getGroupTree.do?id=1').then(function(response) {
        if(response && response.body && response.body.status === 0){
          var zNodes = response.data.data;
          if(zNodes && zNodes.length > 0){
            zNodes[0].open = true;
            zNodes[0].iconOpen = "/static/ztree/img/company.gif";
            zNodes[0].iconClose = "/static/ztree/img/company.gif";
            zNodes[0].icon = "/static/ztree/img/company.gif";
            for(var i = 1; i < zNodes.length; i++){
              zNodes[i].icon = "/static/ztree/img/folder.gif";
              zNodes[i].pId = "1";
            }
            $.fn.zTree.init($("#groupTree"), that.initTreeSettings(), zNodes);
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
</style>
