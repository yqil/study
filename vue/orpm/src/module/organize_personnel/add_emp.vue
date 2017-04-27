<!-- 增加员工组件 -->
<template>
    <div class="add-dep">
        <p class="add-dep-top">
            新增员工信息
        </p>
        <p class="add-dep-desc">
            在这里你可以新增员工信息。
        </p>
        <p class="add-dep-prompt">
            请在下方输入员工信息
        </p>
        <el-row :gutter="20" class="add-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
            <el-col :span="3" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-right">
                    <span>
                        姓名：
                    </span>
                </div>
            </el-col>
            <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-left">
                    <span>
                        <el-input placeholder="请输入员工姓名" v-model="empData.username">
                        </el-input>
                    </span>
                </div>
            </el-col>
            <el-col :span="5" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-right">
                    <span>
                        花名：
                    </span>
                </div>
            </el-col>
            <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-left">
                    <span>
                        <el-input placeholder="请输入员工花名" v-model="empData.shortname">
                        </el-input>
                    </span>
                </div>
            </el-col>
        </el-row>
        <el-row :gutter="20" class="add-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
            <el-col :span="3" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-right">
                    <span>
                        工号：
                    </span>
                </div>
            </el-col>
            <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-left">
                    <span>
                        <el-input placeholder="请输入员工工号" v-model="empData.no">
                        </el-input>
                    </span>
                </div>
            </el-col>
            <el-col :span="5" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-right">
                    <span>
                        性别：
                    </span>
                </div>
            </el-col>
            <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-left">
                    <span>
                        <el-select placeholder="请选择" v-model="empData.sex">
                            <el-option :label="item.value" :value="item.id" v-for="item in sexType">
                            </el-option>
                        </el-select>
                    </span>
                </div>
            </el-col>
        </el-row>
        <el-row :gutter="20" class="add-dep-row-boder" style="margin-left: 0;margin-right: 0;height: 100%;">
            <el-col :span="3" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-right">
                    <span>
                        手机号码：
                    </span>
                </div>
            </el-col>
            <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-left">
                    <span>
                        <el-input placeholder="请输入员工手机号码" v-model="empData.mobile">
                        </el-input>
                    </span>
                </div>
            </el-col>
            <el-col :span="5" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-right">
                    <span>
                        邮箱：
                    </span>
                </div>
            </el-col>
            <el-col :span="6" style="padding-left: 0;padding-right: 0;">
                <div class="grid-content bg-purple add-dep-text-left">
                    <span>
                        <el-input placeholder="请输入员工邮箱" v-model="empData.email">
                        </el-input>
                    </span>
                </div>
            </el-col>
        </el-row>
        <div class="add-dep-dep-buttons">
            <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
                <el-col :span="4" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple">
                        <el-button @click="SaveAndBack" icon="check" type="primary">
                            保存并返回
                        </el-button>
                    </div>
                </el-col>
                <el-col :span="4" style="padding-left: 0;padding-right: 0;">
                    <div class="grid-content bg-purple">
                        <el-button @click="notSaveAndBack" icon="close" type="primary">
                            不保存并返回
                        </el-button>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>
<script>
    export default {
	    name: 'addEmp',
	    data: function(){
	    	return {
	    		sexType: [
	          		{id: 1, value: '男'},
	          		{id: 2, value: '女'}
	        	],
	        	empData: {
	        		sex: 1
	        	},
	        	depId: null
	        }
	    },
	    mounted: function(){
	      this.depId = this.$route.params.id;
	    },
	    watch: {
	      '$route' (to, from) {
	      	this.depId = to.params.id;
	      }
	    },
	    methods: {
	      SaveAndBack(){
	        var data = {
	          username: this.empData.username,
	          shortname: this.empData.shortname,
	          sex: this.empData.sex,
	          no: this.empData.no,
	          mobile: this.empData.mobile,
	          email: this.empData.email,
	          departmentId: this.depId
	        };
	        this.$http.post('/orpm/saveEmp.do?', data, {emulateJSON:true}).then(function(response) {
	          if(response && response.body && response.body.status === 0){
				this.$store.dispatch("changeTreeNode", new Date())
	          	this.$router.go(-1);
	          }else {
	          	this.showErrNotification("错误提示", response.body.msg);
	          }
	        }, function(response) {
	          // error callback
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
<style scoped="">
    .add-dep-top {
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
	  .add-dep-desc {
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
	  .add-dep-prompt {
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
	  .add-dep-row-boder:first-child {
	    border-top: 1px dotted #ccc;
	  }
	  .add-dep-row-boder {
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
	  .add-dep-text-left {
	    text-align: left;
	  }
	  .add-dep-text-left>span {
	    padding-left: 5px;
	  }
	  .add-dep-text-right {
	    text-align: right;
	  }
	  .add-dep-text-right>span {
	    padding-right: 5px;
	  }
	  .add-dep-dep-buttons {
	    width: 90%;
	    margin: 30px auto;
	    text-align: center;
	  }
</style>