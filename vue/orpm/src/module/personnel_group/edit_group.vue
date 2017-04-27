<!-- 修改组信息 -->
<template>
	<div class="edit-group">
		<p class="edit-group-top">修改组信息</p>
		<p class="edit-group-name">请在下方输入组信息</p>

		<div v-show="ifShowErr">
			<el-row :gutter="20" class="edit-group-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
		      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple edit-group-text-right edit-group-text"><span>组名称：</span></div>
		      </el-col>
		      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple edit-group-text-left"><span><el-input placeholder="请输入组名称" v-model="groupData.groupname"></el-input></span></div>
		      </el-col>
		    </el-row>
		    <el-row :gutter="20" class="edit-group-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
		      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple edit-group-text-right edit-group-text"><span>组描述：</span></div>
		      </el-col>
		      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple edit-group-text-left edit-group-des"><span><el-input type="textarea" :rows="4" placeholder="请输入组描述信息" v-model="groupData.remark">
				</el-input></span></div>
		      </el-col>
		    </el-row>
		    <el-row :gutter="20" class="edit-group-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
		      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple edit-group-text-right edit-group-text"><span>组类型：</span></div>
		      </el-col>
		      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
		        <div class="grid-content bg-purple edit-group-text-left"><span><el-select v-model="groupData.grouptype" placeholder="请选择">
	    		     <el-option
	              v-for="item in groupType"
	              :label="item.value"
	              :value="item.id">
	            </el-option>
	  		    </el-select></span></div>
		      </el-col>
		    </el-row>

		    <div class="edit-group-buttons">
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
	export default {
	    name: 'editGroup',
	    data: function (){
	      return {
	        groupData: {},
	        groupType: [{
	        	id: 1, value: "权限"
	        },{
	        	id: 2, value: "流程"
	        },{
	        	id: 3, value: "发文"
	        }],
	        ifShowErr: false,
	        groupId: null
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
		            that.ifShowErr = true;
		          	response.body.data.grouptype = parseInt(response.body.data.grouptype);
		            that.groupData = response.body.data;
		          }else if(response && response.body && response.body.status !== 0){
		            this.showErrNotification("错误提示", response.data.msg);
		          }else {
		            this.showErrNotification("错误提示", "系统出现异常");
		          }
		        }, function(response) {
		          this.showErrNotification("错误提示", "获取部门信息失败");
		        });
		    },
		    SaveAndBack(){
        		var data = {
	        		id: this.groupData.id,
	          		groupname: this.groupData.groupname,
		          	remark: this.groupData.remark,
		          	grouptype: this.groupData.grouptype
	        	};
	        	this.$http.post('/orpm/saveGroup.do?', data, {emulateJSON:true}).then(function(response) {
		        	if(response && response.body && response.body.status === 0){
		        		this.$store.dispatch("changeGroupTreeNode", new Date())
		          		this.$router.go(-1);
		        	}else if(response && response.body && response.body.status !== 0){
		            	this.showErrNotification("错误提示", response.data.msg);
		          	}else {
		            	this.showErrNotification("错误提示", "系统出现异常");
		          	}
	        	}, function(response) {
	          		this.showErrNotification("错误提示", "保存部门信息出现异常");
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
	.edit-group-top {
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
  	.edit-group-name {
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
  	.edit-group-list {
  		margin-top: 30px;
  	}
  	.edit-group-row-boder:first-child {
		border-top: 1px dotted #ccc;
  	}
	.edit-group-row-boder {
    	border-bottom: 1px dotted #ccc;
  	}
  	.edit-group-text>span {
	    font-size: 12px;
	    height: 40px;
	    line-height: 40px;
	    display: block;
	    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
	    text-overflow:ellipsis;
  	}
  	.edit-group-des>span {
	    display: block;
	    word-break:keep-all;/* 不换行 */  
	    white-space:nowrap;/* 不换行 */  
	    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
	    text-overflow:ellipsis;
  	}
  	.edit-group-text-left {
    	text-align: left;
  	}
  	.edit-group-text-right {
    	text-align: right;
  	}
  	.edit-group-text-right>span {
    	padding-right: 5px;
    	font-size: 14px;
  	}
  	.edit-group-buttons {
	    width: 90%;
	    margin: 15px 0;
	    margin-bottom: 5px;
	    text-align: center;
  	}
</style>