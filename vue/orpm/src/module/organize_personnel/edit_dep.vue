<!-- 编辑部门组件 -->
<template>
  <div class="edit-dep">
    <el-dialog title="请选择部门领导" v-model="dialogTableVisible">
      <div class="dialog-content">
        <selectEmployee></selectEmployee>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancleSelectDep">取 消</el-button>
        <el-button type="primary"  @click="confirmSelectDep">确 定</el-button>
      </div>
    </el-dialog>

    <p class="edit-dep-top">修改机构信息</p>
    <p class="edit-dep-desc">在这里你可以修改机构信息。</p>
    <p class="edit-dep-prompt">请在下方输入机构信息</p>
    <el-row :gutter="20" class="edit-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-right"><span>机构名称：</span></div>
      </el-col>
      <el-col :span="6" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-left"><span><el-input v-model="depData.name" placeholder="请输入机构名称"></el-input></span></div>
      </el-col>
      <el-col :span="5" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-right"></div>
      </el-col>
      <el-col :span="6" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-left"></div>
      </el-col>
    </el-row>
    <el-row :gutter="20" class="edit-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-right"><span>机构简称：</span></div>
      </el-col>
      <el-col :span="6" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-left"><span><el-input v-model="depData.shortname" placeholder="请输入机构简称"></el-input></span></div>
      </el-col>
      <el-col :span="5" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-right"><span>机构负责人：</span></div>
      </el-col>
      <el-col :span="6" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-left"><span><el-input v-model="depData.leader" placeholder="请输入机构负责人" @focus="selectLeader"></el-input></span></div>
      </el-col>
    </el-row>
    <el-row :gutter="20" class="edit-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-right"><span>机构类型：</span></div>
      </el-col>
      <el-col :span="6" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-left"><span><el-select v-model="depData.departmenttype" placeholder="请选择">
    		     <el-option
              v-for="item in depType"
              :label="item.value"
              :value="item.id">
            </el-option>
  		    </el-select></span>
  		  </div>
      </el-col>
      <el-col :span="5" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-right"><span>机构标识：</span></div>
      </el-col>
      <el-col :span="6" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple edit-dep-text-left"><span><el-select v-model="depData.type" placeholder="请选择">
        <el-option
          v-for="item in depTag"
          :label="item.value"
          :value="item.id">
        </el-option>
      </el-select></span></div>
      </el-col>
    </el-row>

    <div class="edit-dep-dep-buttons">
      <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="check" @click="SaveAndBack">保存并返回</el-button>
          </div>
        </el-col>
        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
          <div class="grid-content bg-purple">
            <el-button type="primary" icon="close" @click="notSaveAndBack">不保存并返回</el-button>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
  </div>

</template>

<script>
  import selectEmployee from '../../components/select_employee';

  export default {
    name: 'editDep',
    components: {
        selectEmployee
    },
    data: function(){
    	return {
    		depType: [
          {id: 1, value: '公司'},
          {id: 2, value: '部门'}
        ],
        depTag: [
          {id: 1, value: '普通部门'},
          {id: 2, value: '行政部门'},
          {id: 3, value: '领导部门'}
        ],
        dialogTableVisible: false,
        depData: {}
    	}
    },
    mounted: function(){
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
          if(response && response.body){
            response.body.data.type = parseInt(response.body.data.type);
            that.depData = response.body.data;
          }
        }, function(response) {
          this.showErrNotification("错误提示", "获取部门信息出现异常！");
        });
      },
      selectLeader: function(){
          this.$store.dispatch("changeInitSelectedEmplyeeInfo", this.initSelectedEmplyee());
          this.dialogTableVisible = true;
      },
      initSelectedEmplyee: function(){
          if(!this.depData || !this.depData.leaderid) return [];
          return [{
            relationshipId: this.depData.leaderid,
            name: this.depData.leader
          }];
      },
      confirmSelectDep: function(){
          var selectedEmployee = this.$store.state.selectedEmployeeInfo;
          if(selectedEmployee && selectedEmployee.length > 1){
            this.showErrNotification("错误提示", "只能选择一个部门领导，请重新选择！");
          }else if(selectedEmployee){
            this.depData.leader = selectedEmployee[0].name;
            this.depData.leaderid = selectedEmployee[0].relationshipId;
            this.dialogTableVisible = false;
          }
      },
      cancleSelectDep: function(){
          this.dialogTableVisible = false;
      },
      SaveAndBack(){
        var data = {
          name: this.depData.name,
          id: this.depData.id,
          shortname: this.depData.shortname,
          leader: this.depData.leader,
          leaderid: this.depData.leaderid,
          departmenttype: this.depData.departmenttype,
          type: this.depData.type
        };

        this.$http.post('/orpm/saveDep.do?', data, {emulateJSON:true}).then(function(response) {
          this.$store.dispatch("changeTreeNode", new Date())
          this.$router.go(-1);
        }, function(response) {
          // error callback
          this.showErrNotification("错误提示", "系统出现异常");
        });
      },
      notSaveAndBack(){
        this.$router.go(-1);
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
  .edit-dep-top {
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
  .edit-dep-desc {
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
  .edit-dep-prompt {
    color: #C60000;
    font-size: 12px;
    padding: 8px 0;
    text-indent: 25px;
    font-weight: bold;
    height: 26px;
    line-height: 26px;
    border-bottom: 1px dotted #ccc;
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
  }
  /*.edit-dep-row-boder:first-child {
    border-top: 1px dotted #ccc;
  }*/
  .edit-dep-row-boder {
    border-bottom: 1px dotted #ccc;
  }
  .bg-purple>span {
    font-size: 14px;
    height: 40px;
    line-height: 40px;
    display: block;
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
  }
  .edit-dep-text-left {
    text-align: left;
  }
  .edit-dep-text-left>span {
    padding-left: 5px;
  }
  .edit-dep-text-right {
    text-align: right;
  }
  .edit-dep-text-right>span {
    padding-right: 5px;
  }
  .edit-dep-dep-buttons {
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
