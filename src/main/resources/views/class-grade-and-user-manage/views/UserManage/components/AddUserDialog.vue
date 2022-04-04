<template>
  <el-dialog title="添加用户" v-model="visible" :close-on-click-modal="false" @closed="cancel"
             destroy-on-close width="60%" @closed="cancel">
    <el-form style="margin-top: 20px;" label-width="120px">
      <el-form-item label="登录名">
        <el-input v-model="userForm.loginName" placeholder="登录名"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="userForm.name" placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="角色">
        <el-select v-model="userForm.role">
          <el-option key="ROLE_TEACHER" value="ROLE_TEACHER" label="教师"/>
          <el-option key="ROLE_PARENTS" value="ROLE_PARENTS" label="家长"/>
        </el-select>
      </el-form-item>
      <el-form-item  label="密码">
        <el-input v-model="userForm.password" type="password" placeholder="密码" show-password></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <div>
        <el-button type="primary">添加</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script>
export default {
  name: "AddUserDialog",
  props: {
    visible: Boolean
  },
  emits: ['on-cancel', 'on-confirm'],
  data(){
    return {
      userForm:{
        name:null,
        loginName:null,
        role:null,
        password:null
      }
    }
  },
  methods:{
    /**
     * 取消回调
     */
    cancel() {
      this.$emit('on-cancel');
    },
    /**
     * 确定添加
     */
    confirmAdd(){

    }
  }
}
</script>

<style scoped>

</style>