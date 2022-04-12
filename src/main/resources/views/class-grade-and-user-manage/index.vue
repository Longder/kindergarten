<template>
  <el-container style="width: 90%;margin: 0 auto;">
    <el-aside width="200px" style="margin-top: 40px;">
      <el-menu
          router
          default-active="/classGradeAndUserManage/userManage">
        <el-menu-item index="/classGradeAndUserManage/userManage">
          <i class="el-icon-menu"></i>
          <template #title>用户管理</template>
        </el-menu-item>
        <el-menu-item index="/classGradeAndUserManage/classGradeManage">
          <i class="el-icon-document"></i>
          <template #title>班级管理</template>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main class="main-container">
      <router-view></router-view>
    </el-main>
  </el-container>
</template>
<script>
export default {
  name: 'ClassGradeAndUserManage',
  components: {
  },
  data() {
    return {
      bodyStyle: {
        padding: '20px 0 0 0',
        'text-align': 'center'
      }
    };
  },
  methods: {

  }
}
</script>