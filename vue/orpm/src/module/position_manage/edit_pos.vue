<!-- 编辑职位信息 -->
<template>
	<div class="edit-pos">
		<p class="edit-pos-top">新增职位</p>
		<p class="edit-pos-prompt">请在下方输入职位信息</p>
		<el-row :gutter="20" class="edit-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-right edit-pos-text"><span>职位名称：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-left edit-pos-text"><span><el-input placeholder="请输入职位名称" v-model="posData.name"></el-input></span></div>
	      </el-col>
	    </el-row>
	    <el-row :gutter="20" class="edit-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-right edit-pos-text"><span>职位类别：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-left edit-pos-text"><span><el-input placeholder="请输入职位名称"></el-input></span></div>
	      </el-col>
	    </el-row>
	    <el-row :gutter="20" class="edit-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-right edit-pos-text"><span>职位描述：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-left edit-pos-des">
		        <span>
		        	<el-input type="textarea" :rows="4" placeholder="请输入职位描述信息" v-model="posData.remark">
				</el-input>
		        </span>
			</div>
	      </el-col>
	    </el-row>
	    <el-row :gutter="20" class="edit-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-right  edit-pos-text"><span>职位说明书：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple edit-pos-text-left edit-pos-des">
		        <span>
		        	<el-input type="textarea" :rows="12" placeholder="请输入职位说明书信息" v-model="posData.specification">
				</el-input>
		        </span>
			</div>
	      </el-col>
	    </el-row>

	    <div class="edit-pos-buttons">
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
</template>

<script>
	export default {
		name: 'editPos',
	    data: function(){
	    	return {
	    		posData: {},
	        	parentId: null
	        }
	    },
	    mounted: function(){
	      this.getPos(this.$route.params.id);
	    },
	    watch: {
	      '$route' (to, from) {
	      	this.getPos(to.params.id);
	      }
	    },
	    methods: {
	    	getPos(id){
	    		var that = this;
		        this.$http.get('/orpm/getPosition.do?id='+id).then(function(response) {
		          if(response && response.body && response.body.status === 0){
		            that.ifShowErr = true;
		            that.posData = response.body.data;
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
	        		id: this.posData.id,
	          		name: this.posData.name,
		          	specification: this.posData.specification,
		          	remark: this.posData.remark,
		          	departmentid: this.posData.departmentid
	        	};
	        	this.$http.post('/orpm/savePosition.do?', data, {emulateJSON:true}).then(function(response) {
		        	if(response && response.body && response.body.status === 0){
		        		this.$store.dispatch("changePostionTreeNode", new Date())
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
	.edit-pos-top {
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
  	.edit-pos-prompt {
	    color: #C60000;
	    font-size: 18px;
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
  	.edit-pos-row-boder:first-child {
    	border-top: 1px dotted #ccc;
  	}
  	.edit-pos-row-boder {
    	border-bottom: 1px dotted #ccc;
  	}
  	.edit-pos-text>span {
	    font-size: 14px;
	    height: 40px;
	    line-height: 40px;
	    display: block;
	    word-break:keep-all;/* 不换行 */  
	    white-space:nowrap;/* 不换行 */  
	    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
	    text-overflow:ellipsis;
  	}
  	.edit-pos-des>span {
	    display: block;
	    word-break:keep-all;/* 不换行 */  
	    white-space:nowrap;/* 不换行 */  
	    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
	    text-overflow:ellipsis;
  	}
  	.edit-pos-text-left {
    	text-align: left;
  	}
  	.edit-pos-text-left>span {
    	padding-left: 5px;
  	}
  	.edit-pos-text-right {
    	text-align: right;
  	}
  	.edit-pos-text-right>span {
    	padding-right: 5px;
  	}
  	.edit-pos-buttons {
	    width: 90%;
	    margin: 30px auto;
	    text-align: center;
  	}
</style>