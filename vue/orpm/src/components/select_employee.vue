<!-- 选择员工组件 -->
<template>
	<div class="op-index">
	    <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
	      <el-col :span="12" class="orpm_left" style="padding-left: 0;padding-right: 0;">
	        <p class="se-select">请选择</p>
	        <div class="grid-content bg-purple">
	          <ul id="selectEmpDepTree" class="ztree"></ul>
	        </div>
	      </el-col>
	      <el-col :span="12" class="orpm_right" style="padding-left: 0;padding-right: 0;">
	        <p class="se-select se-selected">已选择</p>
	        <div class="grid-content bg-purple">
	          <el-table :data="selectedEmployee" border :show-header=false style="width: 100%">
			    <el-table-column prop="name" label="姓名" align="center"></el-table-column>
			    <el-table-column label="操作" align="center">
			      <template scope="scope">
			        <i @click="delEmployee(scope.$index, scope.row)" class="el-icon-close icon-color"></i>
			      </template>
			    </el-table-column>
			  </el-table>
	        </div>
	      </el-col>
	    </el-row>
	  </div>
</template>

<script>
	import '../assets/ztree/jquery.ztree.core.min.js';
	import {mapGetters} from 'vuex';

	export default {
	    name: 'selectEmployee',
	    data: function(){
	    	return {
	    		selectedEmployee: [],
	    		ifShowTabHeader: false,
	    		selectedEmployeeNode: {}
	    	}
	    },
	    computed: mapGetters(['getInitSelectedEmplyeeInfo']),
		watch: {
		    getInitSelectedEmplyeeInfo: function(val){
		    	console.log("watch-getInitSelectedEmplyeeInfo");
		    	this.initDepTree();
		      	// this.selectedEmployee = val;
		      	this.getSelectedEmployee(val);
		      	this.initSelectedEmployee();
		    }
		},
	    mounted: function(){
	    	console.log("mounted-getInitSelectedEmplyeeInfo");
		    this.initDepTree();
		    this.getSelectedEmployee(this.$store.state.initSelectedEmployeeInfo);
		    // this.selectedEmployee = this.$store.state.initSelectedEmployeeInfo;
		    this.initSelectedEmployee();
		},
		methods: {
			delEmployee: function(idx, row){
				this.selectedEmployeeNode[this.selectedEmployee[idx].relationshipId] = null;
				this.selectedEmployee.splice(idx, 1);
			},
			initSelectedEmployee: function(){
				if(!this.selectedEmployee) return;
				for(var i = 0; i < this.selectedEmployee.length; i++){
					this.selectedEmployeeNode[this.selectedEmployee[i].relationshipId] = "1";
				}
			},
			getSelectedEmployee: function(employee){
				if(!employee) return ;
				for(var i = 0; i < employee.length; i++){
					this.selectedEmployee.push({
	            		id: employee[i].id,
	            		name: employee[i].name,
	            		depName: employee[i].depName,
	            		posName: employee[i].posName,
	            		relationshipId: employee[i].relationshipId
	            	});
				}
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
		          onDblClick: function(event, treeId, treeNode, clickFlag){
		            if(treeNode.type === 2){
		            	if(!that.selectedEmployeeNode[treeNode.relationshipId]){
		            		that.selectedEmployeeNode[treeNode.relationshipId] = "1";
		            		console.log("选择信息："+treeNode.empName);
		            		that.selectedEmployee.push({
			            		id: treeNode.id,
			            		name: treeNode.empName,
			            		depName: treeNode.getParentNode().name,
			            		posName: treeNode.posName,
			            		relationshipId: treeNode.relationshipId
			            	});
			            	that.$store.dispatch("changeSelectedEmplyeeInfo", that.selectedEmployee)
		            	}
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
		            $.fn.zTree.init($("#selectEmpDepTree"), that.initTreeSettings(), zNodes);
		          }
		        }else if(response && response.body && response.body.status !== 0){
		          this.showErrNotification("错误提示", response.data.msg);
		        }else {
		          this.showErrNotification("错误提示", "系统出现异常");
		        }
		      }, function(response) {
		        this.showErrNotification("错误提示", "初始化部门人员树失败");
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
	p{
	    padding: 0;
	    margin: 0;
  	}
  	.op-index {
	    font-family: 'Avenir', Helvetica, Arial, sans-serif;
	    -webkit-font-smoothing: antialiased;
	    -moz-osx-font-smoothing: grayscale;
	    color: #2c3e50;
	    width: 100%;
	    height: 100%;
	}
  	.orpm_left {
	    height: 100%;
	    border: 1px solid #ccc;
	    overflow: auto;
  	}
  	.orpm_right{
	    height: 100%;
	    border: 1px solid #ccc;
  	}
	.se-select{
		background-color: #EEEEEE;
		height: 30px;
		line-height: 30px;
		font-size: 12px;
		color: red;
		text-align: center;
		width: 100%;
	}
	.se-selected{
		color: black;
	}
	.icon-color{
		color: red;
	}
</style>