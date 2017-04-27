<!-- 组织人员右侧部门信息查看页面 -->
<template>
  <div class="look-dep">

    <el-dialog title="请选择部门" v-model="dialogTableVisible">
      <div class="dialog-content">
        <ul id="selectDepTree" class="ztree"></ul>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancleSelectDep">取 消</el-button>
        <el-button type="primary"  @click="confirmSelectDep">确 定</el-button>
      </div>
    </el-dialog>

    <p class="look-dep-top">查看机构信息</p>
    <p class="look-dep-desc">在这里你可以修改本部门信息，也可以新增下级机构和增加本部门员工。</p>
    <p class="look-dep-name">{{depData.name}}</p>

    <div v-show="ifShowErr">
      <el-row :gutter="20" class="look-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
        <el-col :span="3" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"><span>机构名称：</span></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"><span>{{depData.name}}</span></div>
        </el-col>
        <el-col :span="5" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"></div>
        </el-col>
      </el-row>
      <el-row :gutter="20" class="look-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
        <el-col :span="3" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"><span>机构简称：</span></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"><span>{{depData.shortname}}</span></div>
        </el-col>
        <el-col :span="5" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"><span>机构负责人：</span></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"><span>{{depData.leader}}</span></div>
        </el-col>
      </el-row>
      <el-row :gutter="20" class="look-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
        <el-col :span="3" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"><span>机构类型：</span></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"><span>{{depData.departmentTypeName}}</span></div>
        </el-col>
        <el-col :span="5" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"><span>机构编码：</span></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"><span>{{depData.no}}</span></div>
        </el-col>
      </el-row>
      <el-row :gutter="20" class="look-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
        <el-col :span="3" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"><span>机构标识：</span></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"><span>{{depData.typeName}}</span></div>
        </el-col>
        <el-col :span="5" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-right"></div>
        </el-col>
        <el-col :span="6" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple look-dep-text-left"></div>
        </el-col>
      </el-row>
    </div>
    
    <div class="look-dep-dep-buttons" v-show="ifShowErr">
      <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="edit" @click="editDep">修改本机构</el-button>
          </div>
        </el-col>
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="plus" @click="addDep">新增部门</el-button>
          </div>
        </el-col>
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="plus" @click="addEmp">增加员工</el-button>
          </div>
        </el-col>
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="edit" @click="moveDep">迁移部门</el-button>
          </div>
        </el-col>
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="arrow-up">向上排序</el-button>
          </div>
        </el-col>
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="arrow-down">向下排序</el-button>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'lookDep',
    data: function (){
      return {
        depData: {},
        ifShowErr: false,
        dialogTableVisible: false,
        dialogSeleteDep: null
      }
    },
    mounted: function(){
      // this.initDepTree();
      this.getDep(this.$route.params.id);
    },
    watch: {
      '$route' (to, from) {
        this.getDep(to.params.id);
      }
    },
    methods: {
      getDep(id){
        var that = this;
        this.$http.get('/orpm/getDep.do?id='+id).then(function(response) {
          console.log("index1");
          if(response && response.body && response.body.status === 0){
            that.ifShowErr = true;
            response.body.data.type = parseInt(response.body.data.type);
            if(response.body.data.departmenttype === 1){
              response.body.data.departmentTypeName = "公司";
            }else if(response.body.data.departmenttype === 2){
              response.body.data.departmentTypeName = "部门";
            }
            if(response.body.data.type === 1){
              response.body.data.typeName = "普通部门";
            }else if(response.body.data.type === 2){
              response.body.data.typeName = "行政部门";
            }else if(response.body.data.type === 3){
              response.body.data.typeName = "领导部门";
            }
            that.depData = response.body.data;
          }else if(response && response.body && response.body.status !== 0){
            this.showErrNotification("错误提示", response.data.msg);
          }else {
            this.showErrNotification("错误提示", "系统出现异常");
          }
        }, function(response) {
          // error callback
          this.showErrNotification("错误提示", "获取部门信息失败");
        });
      },
      addDep(){
        this.$router.push({name: 'addDep', params: {id: this.depData.id}});
      },
      editDep(){
        this.$router.push({name: 'editDep', params: {id: this.depData.id}});
      },
      addEmp(){
        this.$router.push({name: 'addEmp', params: {id: this.depData.id}});
      },
      moveDep(){
        this.dialogSeleteDep = null;
        this.initDepTree();
        this.dialogTableVisible = true;
      },
      confirmSelectDep: function(){
        var data = {
          name: this.depData.name,
          id: this.depData.id,
          shortname: this.depData.shortname,
          leader: this.depData.leader,
          departmenttype: this.depData.departmenttype,
          type: this.depData.type,
          parentid: this.dialogSeleteDep
        };
        this.$http.post('/orpm/saveDep.do?', data, {emulateJSON:true}).then(function(response) {
          this.dialogSeleteDep = null;
          this.dialogTableVisible = false;
          this.$store.dispatch("changeTreeNode", new Date())
        }, function(response) {
          this.showErrNotification("错误提示", "系统出现异常");
        });
      },
      cancleSelectDep: function(){
        this.dialogSeleteDep = null;
        this.dialogTableVisible = false;
      },
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
              that.dialogSeleteDep = treeNode.id;
            }
          }
        };
      },
      initDepTree: function(){
        var that = this;
        this.$http.get('/orpm/getDepTree.do?id=1').then(function(response) {
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
              $.fn.zTree.init($("#selectDepTree"), that.initTreeSettings(), zNodes);
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
  .look-dep-top {
    color: #374C68;
    height: 26px;
    line-height: 26px;
    text-indent: 5px;
    background: url(../../assets/img/bg.gif) repeat-x;
    border-bottom: 1px solid #7099CE;
    margin: 0;
    border: 1px solid #7099CE;
    font-size: 12px;
  }
  .look-dep-desc {
    color: #374C68;
    height: 26px;
    line-height: 26px;
    font-size: 12px;
    text-indent: 15px;
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
  }
  .look-dep-name {
    color: #C60000;
    font-size: 12px;
    margin: 8px 0;
    text-indent: 25px;
    font-weight: bold;
    height: 26px;
    line-height: 26px;
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
  }
  .look-dep-row-boder:last-child {
    border-bottom: 1px dotted #ccc;
  }
  .look-dep-row-boder {
    border-top: 1px dotted #ccc;
  }
  .bg-purple>span {
    font-size: 14px;
    height: 30px;
    line-height: 30px;
    display: block;
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
  }
  .look-dep-text-left {
    text-align: left;
  }
  .look-dep-text-left>span {
    padding-left: 5px;
  }
  .look-dep-text-right {
    text-align: right;
  }
  .look-dep-text-right>span {
    padding-right: 5px;
  }
  .look-dep-dep-buttons {
    width: 90%;
    margin: 30px auto;
    text-align: center;
  }
  .dialog-content {
    height: 300px;
    overflow: auto;
    border: 1px solid #ccc;
  }
</style>
