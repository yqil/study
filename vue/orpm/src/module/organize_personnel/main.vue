<template>
  <div class="op-index">
    <el-row :gutter="24" style="margin-left: 0;margin-right: 0;height: 100%;">
      <el-col :span="6" class="orpm_left" style="padding-left: 0;padding-right: 0;">
        <div class="grid-content bg-purple">
          <depTree></depTree>
        </div>
      </el-col>
      <el-col :span="18" class="orpm_right" style="padding-left: 0;padding-right: 0;overflow:auto;">
        <div class="grid-content bg-purple">
          <router-view></router-view>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import depTree from '../../components/dep_emp_tree'

  export default {
    name: 'index',
    components: {
      depTree
    }
  }
</script>

<style>
  html, body {
    margin: 0; 
    padding: 0;
    height: 100%; 
    background-color: #ffffff;
  }
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
    border-top: 4px solid #75BB45;
    border-left: 3px solid #90B0DA;
    border-right: 3px solid #90B0DA;
    border-bottom: 3px solid #90B0DA;
    overflow: auto;
  }
  .orpm_right{
    height: 100%;
    border-top: 4px solid #75BB45;
    border-left: 1px solid #90B0DA;
    border-right: 3px solid #90B0DA;
    border-bottom: 3px solid #90B0DA;
  }
</style>
