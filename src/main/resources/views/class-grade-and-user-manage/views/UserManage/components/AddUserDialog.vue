<template>
  <el-dialog title="新增用户" v-model="visible" :close-on-click-modal="false" @closed="cancel"
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
      <el-form-item label="头像">
        <el-upload ref="avatarUpload" @change="handleChange" :limit="1" :multiple="false" action="#" list-type="picture-card" :auto-upload="false" />
      </el-form-item>
      <el-form-item  label="密码">
        <el-input v-model="userForm.password" type="password" placeholder="密码" show-password></el-input>
      </el-form-item>
      <el-form-item  label="确认密码">
        <el-input v-model="userForm.confirmPassword" type="password" placeholder="密码" show-password></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <div>
        <el-button type="primary" @click="confirmAdd">添加</el-button>
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
        password:null,
        avatar:null,
        confirmPassword:null
      }
    }
  },
  methods:{
    /**
     * 取消回调
     */
    cancel() {
      this.userForm = {
        name:null,
        loginName:null,
        role:null,
        password:null,
        avatar:null,
        confirmPassword:null
      };
      this.$emit('on-cancel');
    },
    /**
     * 确定添加
     */
    confirmAdd(){
      axios.post('/admin/userManage/addUser', this.userForm).then(response => {
        if (response.data.success) {
          this.$notify.success({
            title: '保存成功',
          });
          this.userForm = {
            name:null,
            loginName:null,
            role:null,
            password:null,
            avatar:null,
            confirmPassword:null
          };
          this.$emit('on-confirm');
        } else {
          this.$notify.error({
            title: '保存用户失败',
            message: response.data.msg
          });
        }
      });
    },
    /**
     * 图片选择回调，处理Base64
     * @param file
     */
    handleChange(file){
      console.log('handleChange');
      console.log(file.raw);
      this.userForm.avatar = file;
      this.getBase64(file.raw).then(result=>{
        this.userForm.avatar = result;
        console.log('base64转换成功:');
        console.log(this.userForm.avatar);
      });
    },
    /**
     * 图片转Base64方法
     */
    getBase64(file) {
      return new Promise(function(resolve, reject) {
        let reader = new FileReader();
        let imgResult = "";
        reader.readAsDataURL(file);
        reader.onload = function() {
          imgResult = reader.result;
        };
        reader.onerror = function(error) {
          reject(error);
        };
        reader.onloadend = function() {
          resolve(imgResult);
        };
      });
    }
  }
}
</script>

<style scoped>

</style>