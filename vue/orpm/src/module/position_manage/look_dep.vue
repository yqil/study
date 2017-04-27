<!-- 组织人员右侧部门信息查看页面 -->
<template>
  <div class="look-dep">
    <p class="look-dep-top">{{depData.name}}</p>
    <p class="look-dep-desc">在这里你可以创建职位、修改职位。</p>
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
            <el-button type="primary" icon="edit" @click="addPos">增加职位</el-button>
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
        ifShowErr: false
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
      addPos(){
        this.$router.push({name: 'addPos', params: {id: this.depData.id}});
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
  /* .dialog-content {
    height: 300px;
    overflow: auto;
    border: 1px solid #ccc;
  } */
</style>
