<!-- 查询岗位信息 -->
<template>
	<div>
		<p class="look-pos-top">查看职位信息</p>
		<p class="look-pos-prompt">{{posData.name}}</p>
		<el-row :gutter="20" class="look-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-right look-pos-text"><span>职位名称：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-left look-pos-text"><span>{{posData.name}}</span></div>
	      </el-col>
	    </el-row>
	    <el-row :gutter="20" class="look-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-right look-pos-text"><span>职位类别：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-left look-pos-text"><span>{{posData.type}}</span></div>
	      </el-col>
	    </el-row>
	    <el-row :gutter="20" class="look-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-right look-pos-text"><span>职位描述：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-left look-pos-des"><span>{{posData.remark}}</span></div>
	      </el-col>
	    </el-row>
	    <el-row :gutter="20" class="look-pos-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="3" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-right look-pos-text"><span>职位说明书：</span></div>
	      </el-col>
	      <el-col :span="17" style="padding-left: 0;padding-right: 0;">
	        <div class="grid-content bg-purple look-pos-text-left look-pos-des"><span>{{posData.specification}}</span></div>
	      </el-col>
	    </el-row>

	    <div class="look-pos-buttons" v-show="ifShowErr">
	      <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
	        <el-col :span="4" style="padding-left: 0;padding-right: 0;">
	          <div class="grid-content bg-purple">
	            <el-button type="primary" icon="edit" @click="editPos">修改职位</el-button>
	          </div>
	        </el-col>
	      </el-row>
	    </div>
	</div>
</template>

<script>
	export default {
	    name: 'lookPos',
	    data: function(){
	    	return {
	    		posData: {},
	    		ifShowErr: false
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
		          // error callback
		          this.showErrNotification("错误提示", "获取部门信息失败");
		        });
	    	},
	      	editPos(){
	        	this.$router.push({name: 'editPos', params: {id: this.posData.id}});
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
	.look-pos-top {
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
  	.look-pos-prompt {
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
  	.look-pos-row-boder:first-child {
    	border-top: 1px dotted #ccc;
  	}
  	.look-pos-row-boder {
    	border-bottom: 1px dotted #ccc;
  	}
  	.look-pos-text>span {
	    font-size: 12px;
	    height: 40px;
	    line-height: 40px;
	    display: block;
	    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
	    text-overflow:ellipsis;
  	}
  	.look-pos-des>span {
  		font-size: 12px;
  		word-wrap: break-word;
  	}
  	.look-pos-text-left {
    	text-align: left;
  	}
  	.look-pos-text-right {
    	text-align: right;
  	}
  	.look-pos-text-right>span {
    	padding-right: 5px;
    	font-size: 14px;
  	}
  	.look-pos-buttons {
	    width: 90%;
	    margin: 30px auto;
	    text-align: center;
  	}
</style>