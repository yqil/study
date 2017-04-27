<!-- 组织人员右侧页面的组件 -->
<template>
    <div class="op">
        <p class="op-top">
            查看员工信息
        </p>
        <p class="op-desc">
            在这里你可以查看员工信息，并进行相关的操作
        </p>
        <p class="op-name">
            {{empData.username}}
        </p>
        <div>
            <el-row :gutter="20" class="op-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
                <el-col :span="3" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-right">
                        <span>
                            姓名：
                        </span>
                    </div>
                </el-col>
                <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-left">
                        <span>
                            {{empData.username}}
                        </span>
                    </div>
                </el-col>
                <el-col :span="5" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-right">
                        <span>
                            花名：
                        </span>
                    </div>
                </el-col>
                <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-left">
                        <span>
                            {{empData.shortname}}
                        </span>
                    </div>
                </el-col>
            </el-row>
            <el-row :gutter="20" class="op-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
                <el-col :span="3" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-right">
                        <span>
                            工号：
                        </span>
                    </div>
                </el-col>
                <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-left">
                        <span>
                            {{empData.no}}
                        </span>
                    </div>
                </el-col>
                <el-col :span="5" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-right">
                        <span>
                            性别：
                        </span>
                    </div>
                </el-col>
                <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-left">
                        <span>
                            {{empData.sexName}}
                        </span>
                    </div>
                </el-col>
            </el-row>
            <el-row :gutter="20" class="op-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
                <el-col :span="3" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-right">
                        <span>
                            手机号码：
                        </span>
                    </div>
                </el-col>
                <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-left">
                        <span>
                            {{empData.mobile}}
                        </span>
                    </div>
                </el-col>
                <el-col :span="5" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-right">
                        <span>
                            邮箱：
                        </span>
                    </div>
                </el-col>
                <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple op-text-left">
                        <span>
                            {{empData.email}}
                        </span>
                    </div>
                </el-col>
            </el-row>
        </div>
        <div class="op-operate-buttons">
            <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
                <el-col :span="4" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple">
                        <el-button @click="editEmp" icon="edit" type="primary">
                            修改员工信息
                        </el-button>
                    </div>
                </el-col>
                <el-col :span="4" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple">
                        <el-button @click="delEmp" icon="delete2" type="primary">
                            删除员工
                        </el-button>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
    // import Bus from '../../status.js'

  export default {
    name: 'lookEmp',
    data: function (){
      return {
        empData: {}
      }
    },
    mounted: function(){
      this.getEmp(this.$route.params.id);
    },
    watch: {
      '$route' (to, from) {
        this.getEmp(to.params.id);
      }
    },
    methods: {
      getEmp(id){
        var that = this;
        this.$http.get('/orpm/getEmp.do?id='+id).then(function(response) {
          if(response && response.body && response.body.status === 0){
            if(response.body.data.sex === 1){
              response.body.data.sexName = "男"
            }else if(response.body.data.sex === 2){
              response.body.data.sexName = "女"
            }else {
              response.body.data.sexName = "未知"
            }
            that.empData = response.body.data
          }else {
            this.showErrNotification("错误提示", response.body.msg);
          }
        }, function(response) {
          // error callback
          this.showErrNotification("错误提示", "获取员工信息失败");
        });
      },
      editEmp(){
        this.$router.push({name: 'editEmp', params: {id: this.empData.id}});
      },
      delEmp(){
        var that = this;
        this.$confirm('此操作将删除【'+this.empData.username+'】员工, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http.get('/orpm/delEmp.do?id='+that.empData.id).then(function(response) {
            if(response && response.body && response.body.status === 0){
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
            }else {
              this.showErrNotification("错误提示", response.body.msg);
            }
          }, function(response) {
            // error callback
            this.showErrNotification("错误提示", "删除员工信息失败");
          });
          
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
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
<style scoped="">
    .op-top {
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
  .op-desc {
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
  .op-name {
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
  .op>div>.op-row-boder:last-child {
    border-bottom: 1px dotted #ccc;
  }
  .op>div>.op-row-boder {
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
  .op-text-left {
    text-align: left;
  }
  .op-text-left>span {
    padding-left: 5px;
  }
  .op-text-right {
    text-align: right;
  }
  .op-text-right>span {
    padding-right: 5px;
  }
  .op-dep-buttons {
    width: 90%;
    margin: 30px auto;
    text-align: center;
  }
  .op-operate-buttons {
    width: 90%;
    margin: 30px auto;
    text-align: center;
  }
</style>
