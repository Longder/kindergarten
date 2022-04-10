<template>
  <el-dialog title="新增班级" v-model="visible" :close-on-click-modal="false" @closed="cancel"
             destroy-on-close width="60%" @closed="cancel">
    <el-form style="margin-top: 20px;" label-width="120px">

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
  name: "AddClassGradeDialog",
  props: {
    visible: Boolean
  },
  emits: ['on-cancel', 'on-confirm'],
  data(){
    return {
      classGradeForm:{
        name:null,
      }
    }
  },
  methods:{
    /**
     * 取消回调
     */
    cancel() {
      this.classGradeForm = {
        name:null,
      };
      this.$emit('on-cancel');
    },
    /**
     * 确定添加
     */
    confirmAdd(){
      axios.post('/admin/classGradeManage/addCLassGrade', this.classGradeForm).then(response => {
        if (response.data.success) {
          this.$notify.success({
            title: '保存成功',
          });
          this.classGradeForm = {
            name:null,
          };
          this.$emit('on-confirm');
        } else {
          this.$notify.error({
            title: '新增班级失败',
            message: response.data.msg
          });
        }
      });
    },
  }
}
</script>

<style scoped>

</style>