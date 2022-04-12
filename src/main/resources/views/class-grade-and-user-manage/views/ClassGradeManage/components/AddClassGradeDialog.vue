<template>
  <el-dialog title="新增班级" v-model="visible" :close-on-click-modal="false" @closed="cancel"
             destroy-on-close width="60%" @closed="cancel">
    <el-form style="margin-top: 20px;" label-width="120px">
      <el-form-item label="班级名称">
        <el-input v-model="classGradeForm.name" placeholder="班级名称"></el-input>
      </el-form-item>
      <el-form-item label="管理教师">
        <el-select v-model="classGradeForm.teacherId">
          <el-option
              v-for="teacher in teacherList"
              :key="teacher.id"
              :label="teacher.name"
              :value="teacher.id"
          />
          <el-option key="ROLE_TEACHER" value="ROLE_TEACHER" label="教师"/>
          <el-option key="ROLE_PARENTS" value="ROLE_PARENTS" label="家长"/>
        </el-select>
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
  name: "AddClassGradeDialog",
  props: {
    visible: Boolean
  },
  emits: ['on-cancel', 'on-confirm'],
  data(){
    return {
      // 教师列表
      teacherList:[],
      classGradeForm:{
        name:null,
        teacherId:null,
      }
    }
  },
  mounted(){
    // 查询所有教师
    axios.get('/admin/classGradeManage/listAllTeacher').then(response=>{
      if(response.data.success){
        this.teacherList = response.data.data;
      }else{
        this.$notify.error({
          title: '查询教师列表失败',
          message: response.data.msg
        });
      }
    });
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