<!-- 查看组信息组件 -->
<template>
	<div class="look-group">
		<el-dialog title="请选择组内成员" v-model="dialogTableVisible">
	      <div class="dialog-content">
	        <selectEmployee></selectEmployee>
	      </div>
	      <div slot="footer" class="dialog-footer">
	        <el-button @click="cancleSelectDep">取 消</el-button>
	        <el-button type="primary"  @click="confirmSelectDep">确 定</el-button>
	      </div>
	    </el-dialog>

		<p class="look-group-top">查看组信息</p>
		<p class="look-group-name">{{groupData.groupname}}</p>
		
		<div v-show="ifShowErr">
			<el-row :gutter="20" class="look-group-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
		      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple look-group-text-right look-group-text"><span>组名称：</span></div>
		      </el-col>
		      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple look-group-text-left look-group-text"><span>{{groupData.groupname}}</span></div>
		      </el-col>
		    </el-row>
		    <el-row :gutter="20" class="look-group-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
		      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple look-group-text-right look-group-text"><span>组描述：</span></div>
		      </el-col>
		      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple look-group-text-left look-group-text"><span>{{groupData.remark}}</span></div>
		      </el-col>
		    </el-row>
		    <el-row :gutter="20" class="look-group-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
		      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple look-group-text-right look-group-text"><span>组类型：</span></div>
		      </el-col>
		      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple look-group-text-left look-group-text"><span>{{groupData.groupName}}</span></div>
		      </el-col>
		    </el-row>
		    <div class="look-group-buttons">
		      <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
		        <el-col :span="24" style="padding-left: 0;padding-right: 0;">
		          <div class="grid-content bg-purple">
		            <el-button type="primary" icon="edit" @click="editGroup">修改组</el-button>
		          </div>
		        </el-col>
		      </el-row>
		    </div>
		</div>
		
		<p class="look-group-name look-group-list">岗位列表</p>
		<div v-show="ifShowErr">
			<el-table
			    :data="employeeData"
			    stripe
			    style="width: 100%">
			    <el-table-column
			      prop="name"
			      label="姓名"
			      align="center">
			    </el-table-column>
			    <el-table-column
			      prop="depName"
			      label="所在部门"
			      align="center">
			    </el-table-column>
			    <el-table-column
			      prop="posName"
			      label="职位"
			      align="center">
			    </el-table-column>
			  </el-table>
		    <div class="look-group-buttons">
		      <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
		        <el-col :span="24" style="padding-left: 0;padding-right: 0;">
		          <div class="grid-content bg-purple">
		            <el-button type="primary" icon="edit" @click="editGroupMember">修改组内成员</el-button>
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
	    name: 'lookGroup',
	    components: {
	      selectEmployee
	    },
	    data: function (){
	      return {
	        groupData: {},
	        ifShowErr: false,
	        dialogTableVisible: false,
	        groupId: null,
	        employeeData: []
	      }
	    },
	    mounted: function(){
	      this.getGroup(this.$route.params.id);
	    },
	    watch: {
	      '$route' (to, from) {
	        this.getGroup(to.params.id);
	      }
	    },
	    methods: {
	      getGroup(id){
	      	var that = this;
	        this.$http.get('/orpm/getGroup.do?id='+id).then(function(response) {
	          if(response && response.body && response.body.status === 0){
	          	if(response.body.data.grouptype === "1"){
	          		response.body.data.groupName = "权限";
	          	}else if(response.body.data.grouptype === "2"){
	          		response.body.data.groupName = "流程";
	          	}else if(response.body.data.grouptype === "3"){
	          		response.body.data.groupName = "发文";
	          	}
	            that.groupData = response.body.data;
	            return that.groupData.id;
	          }else if(response && response.body && response.body.status !== 0){
	            this.showErrNotification("错误提示", response.data.msg);
	          }else {
	            this.showErrNotification("错误提示", "系统出现异常");
	          }
	        }, function(response) {
	          this.showErrNotification("错误提示", "获取部门信息失败");
	        }).then(function(groupId){
	        	this.$http.get('/orpm/getRelationshipGroup.do?groupId='+groupId).then(function(response) {
		          if(response && response.body && response.body.status === 0){
		            that.ifShowErr = true;
		            that.employeeData = response.body.data;
		          }else if(response && response.body && response.body.status !== 0){
		            this.showErrNotification("错误提示", response.data.msg);
		          }else {
		            this.showErrNotification("错误提示", "系统出现异常");
		          }
		        }, function(response) {
		          this.showErrNotification("错误提示", "获取部门信息失败");
		        })
	        });
	      },
	      editGroup(){
	      	this.$router.push({name: 'editGroup', params: {id: this.groupData.id}});
	      },
	      editGroupMember(){
	      	this.$store.dispatch("changeInitSelectedEmplyeeInfo", this.initSelectedEmplyee());
        	this.dialogTableVisible = true;
	      },
	      initSelectedEmplyee: function(){
	      	if(!this.employeeData) return [];
	      	var rs = [];
	      	for(var i = 0; i < this.employeeData.length; i++){
	      		rs.push({
	      			relationshipId: this.employeeData[i].relationshipId,
            		name: this.employeeData[i].name,
            		depName: this.employeeData[i].name,
			        posName: this.employeeData[i].posName
	      		});
	      	}
	      	return rs;
	      },
	      confirmSelectDep: function(){
	      	var selectedEmployee = this.$store.state.selectedEmployeeInfo;
	      	var addEmployee = this.initAddEmployee(selectedEmployee);
	      	var delEmployee = this.initDelEmployee(selectedEmployee);
	      	if(!addEmployee && addEmployee.length == 0 && !delEmployee && delEmployee.length == 0){
	      		return;
	      	}
	      	this.employeeData = selectedEmployee;
	      	var data = {
	      		groupId: this.groupData.id
	      	};
	      	var idx = 0;
	      	for(var i = 0; i < addEmployee.length; i++){
	      		data['relationshipType[' + idx +'].id'] = addEmployee[i].relationshipId;
				data['relationshipType[' + idx +'].type'] = "1";	
	      		idx++;
	      	}
	      	for(var j = 0; j < delEmployee.length; j++){
	      		data['relationshipType[' + idx +'].id'] = delEmployee[j].relationshipId;
				data['relationshipType[' + idx +'].type'] = "2";	
	      		idx++;
	      	}
	      	debugger;
	      	this.$http.post('/orpm/saveRelationshipGroup.do', data, {emulateJSON:true}).then(function(response) {
	        	if(response && response.body && response.body.status === 0){
	          		this.dialogTableVisible = false;
	        	}else if(response && response.body && response.body.status !== 0){
	            	this.showErrNotification("错误提示", response.data.msg);
	          	}else {
	            	this.showErrNotification("错误提示", "系统出现异常");
	          	}
        	}, function(response) {
          		this.showErrNotification("错误提示", "保存部门信息出现异常");
        	});
	      },
	      initAddEmployee: function(newEmployee){
	      	if(!newEmployee) return null;
	      	if(!this.employeeData) return newEmployee;
	      	var rs = [];
	      	var tag = false;
	      	for(var i = 0; i < newEmployee.length; i++){
	      		for(var j = 0; j < this.employeeData.length; j++){
	      			if(newEmployee[i].relationshipId == this.employeeData[j].relationshipId){
	      				tag = true;
	      				break;
	      			}
	      		}
	      		if(!tag) rs.push(newEmployee[i]);
	      		tag = false;
	      	}
	      	return rs;
	      },
	      initDelEmployee: function(newEmployee){
	      	if(!newEmployee) return this.employeeData;
	      	if(!this.employeeData) null;
	      	var rs = [];
	      	var tag = false;
	      	for(var i = 0; i < this.employeeData.length; i++){
	      		for(var j = 0; j < newEmployee.length; j++){
	      			if(this.employeeData[i].relationshipId === newEmployee[j].relationshipId){
	      				tag = true;
	      				break;
	      			}
	      		}
	      		if(!tag) rs.push(this.employeeData[i]);
	      		tag = false;
	      	}
	      	return rs;
	      },
	      cancleSelectDep: function(){
	        this.dialogTableVisible = false;
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
	.look-group-top {
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
  	.look-group-name {
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
  	.look-group-list {
  		margin-top: 30px;
  	}
  	.look-group-row-boder:first-child {
		border-top: 1px dotted #ccc;
  	}
	.look-group-row-boder {
    	border-bottom: 1px dotted #ccc;
  	}
  	.look-group>div{
  		border-bottom: 1px dotted #ccc;
  	}
  	.look-group-text>span {
	    font-size: 12px;
	    height: 40px;
	    line-height: 40px;
	    display: block;
	    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
	    text-overflow:ellipsis;
  	}
  	.look-group-des>span {
  		font-size: 12px;
  		word-wrap: break-word;
  	}
  	.look-group-text-left {
    	text-align: left;
  	}
  	.look-group-text-right {
    	text-align: right;
  	}
  	.look-group-text-right>span {
    	padding-right: 5px;
    	font-size: 14px;
  	}
  	.look-group-buttons {
	    width: 90%;
	    margin: 15px 0;
	    margin-bottom: 5px;
	    text-align: center;
  	}
  	.dialog-content {
	    height: 300px;
	    overflow: auto;
	    border: 1px solid #ccc;
	}
</style>