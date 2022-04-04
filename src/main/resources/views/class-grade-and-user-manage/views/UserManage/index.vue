<template>
  <el-card>
<!--    <el-form :inline="true" size="small">
      <el-form-item label="共享数据名称">
        <el-input placeholder="关键字" v-model="queryParam.keyWord"/>
      </el-form-item>
      <el-form-item label="数据发布部门">
        <el-select
            style="width: 300px;"
            v-model="queryParam.publishOrgId"
            filterable
            remote
            :loading="selectLoading"
            :remote-method="loadOrgSelectList"
            @change="loadMyApply"
            placeholder="数据发布部门">
          <el-option
              v-for="item in orgSelectList"
              :key="item.id"
              :label="item.name"
              :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="loadMyApply">查询</el-button>
      </el-form-item>
    </el-form>-->
    <el-form :inline="true">
      <el-button type="primary" @click="toAddUser">新增用户</el-button>
    </el-form>
    <el-table
        border
        size="small"
        style="width: 100%;margin-top: 30px;">
      <el-table-column
          label="编号"
          prop="applyNo">
      </el-table-column>
      <el-table-column
          label="登录名"
          prop="sharedDataName">
      </el-table-column>
      <el-table-column
          label="姓名"
          prop="sharingMode">
      </el-table-column>
      <el-table-column
          label="角色"
          prop="publishOrg">
      </el-table-column>
      <el-table-column label="操作" width="100">
        <template #default="scope">
          <el-button>修改</el-button>
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
    }
  },
  methods:{
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
    },
  }
}
</script>

<style scoped>

</style>