<template>
  <el-card>
    <el-divider><h3>用户管理</h3></el-divider>
    <el-form :inline="true">
      <el-button type="primary" @click="toAddUser">新增用户</el-button>
    </el-form>
    <el-table
        border
        :data="userList"
        style="width: 100%;margin-top: 30px;">
      <el-table-column
          label="编号"
          width="60"
          prop="id">
      </el-table-column>
      <el-table-column
          label="登录名"
          prop="loginName">
      </el-table-column>
      <el-table-column
          label="姓名"
          prop="name">
      </el-table-column>
      <el-table-column
          label="角色"
          prop="role">
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small">修改</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
  <!--添加用户对话框-->
  <add-user-dialog :visible="userAddDialogVisible" @on-cancel="cancel" @on-confirm="confirm"/>
</template>

<script>
export default {
  name: "UserManage",
  components: {
    'add-user-dialog': loadVue('/views/class-grade-and-user-manage/views/UserManage/components/AddUserDialog.vue'),
  },
  data() {
    return {
      // 添加用户对话框可见性
      userAddDialogVisible: false,
      // 用户列表数据
      userList:[]
    }
  },
  mounted(){
    this.listUser();
  },
  methods:{
    /**
     * 查询用户列表
     */
    listUser(){
      axios.get('/admin/userManage/list').then(response => {
        if (response.data.success) {
          this.userList = response.data.data;
        } else{
          this.$notify.error({
            title: '查询用户列表失败',
            message: response.data.msg
          });
        }
      });
    },
    /**
     * 去添加用户
     */
    toAddUser(){
      this.userAddDialogVisible = true;
    },
    /**
     * 取消回调
     */
    cancel() {
      this.userAddDialogVisible = false;
    },
    /**
     * 确认回调
     */
    confirm() {
      this.userAddDialogVisible = false;
      this.listUser();
    },
  }
}
</script>

<style scoped>

</style>