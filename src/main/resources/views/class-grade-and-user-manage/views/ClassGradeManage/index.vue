<template>
  <el-card>
    <el-divider><h3>班级管理</h3></el-divider>
    <el-form :inline="true">
      <el-button type="primary">新增班级</el-button>
    </el-form>
    <el-table
        border
        :data="classGradeList"
        style="width: 100%;margin-top: 30px;">
      <el-table-column
          label="编号"
          prop="id">
      </el-table-column>
      <el-table-column
          label="名称"
          prop="name">
      </el-table-column>
      <el-table-column
          label="任课教师"
          prop="teacher.name">
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button>修改</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
  <add-class-grade-dialog :visible="classAddDialogVisible" @on-cancel="cancel" @on-confirm="confirm"/>
</template>

<script>
export default {
  name: "ClassGradeManage",
  components: {
    'add-class-grade-dialog': loadVue('/views/class-grade-and-user-manage/views/ClassGradeManage/components/AddClassGradeDialog.vue'),
  },
  data() {
    return {
      // 添加班级对话框可见性
      classAddDialogVisible: false,
      // 班级列表数据
      classGradeList:[]
    }
  },
  mounted(){
    this.listClassGrade();
  },
  methods:{
    // 查询班级列表
    listClassGrade(){
      axios.get("/admin/classGradeManage").then(response=>{
        if(response.data.success){
          this.classGradeList = response.data.data;
        }else{
          this.$notify.error({
            title: '查询班级列表失败',
            message: response.data.msg
          });
        }
      })
    },
    /**
     * 取消回调
     */
    cancel() {
      this.classAddDialogVisible = false;
    },
    /**
     * 确认回调
     */
    confirm() {
      this.classAddDialogVisible = false;
      this.listClassGrade();
    },
  }
}
</script>

<style scoped>

</style>