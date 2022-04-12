<!--教师用管理页-->
<template>
  <el-container style="width: 90%;margin: 0 auto;">
    <el-aside width="200px" style="margin-top: 20px;">
      <el-menu
          router
          default-active="/teacher/activityManage">
        <el-menu-item index="/teacher/activityManage">
          <i class="el-icon-menu"></i>
          <template #title>活动管理</template>
        </el-menu-item>
        <el-menu-item index="/teacher/courseManage">
          <i class="el-icon-document"></i>
          <template #title>每日所学</template>
        </el-menu-item>
        <el-menu-item index="/teacher/dietManage">
          <i class="el-icon-document"></i>
          <template #title>班级饮食</template>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main class="main-container">
      <h1></h1>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'ManageForTeacher',
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

<style scoped>

</style>