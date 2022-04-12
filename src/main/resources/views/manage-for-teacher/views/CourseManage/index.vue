<template>
  <el-card>
    <el-divider><h3>班级每日所学</h3></el-divider>
    <el-form :inline="true">
      <el-form-item label="所选班级">
        <el-select v-model="targetClassId">
          <el-option label="Zone one" value="shanghai" />
          <el-option label="Zone two" value="beijing" />
        </el-select>
      </el-form-item>
      <el-button type="primary">添加每日所学</el-button>
    </el-form>
  </el-card>
</template>

<script>
export default {
  name: "CourseManage",
  data(){
    return {
      // 班级列表
      classList:[],
      // 目标班级id（正在查询）
      targetClassId:null,
      // 课程列表
      courseList:[]
    };
  },
  mounted(){
    // 查询所有班级并指定默认班级
    this.fetchClassData();
  },
  watch: {
    /**
     * 监听属性变化
     */
    targetClassId(newValue) {
      console.log("切换class:",newValue);
      this.listCourses(newValue);
    }
  },
  methods:{
    // 查询班级数据
    fetchClassData(){
      axios.get('/getCurrentTeacherClass').then(response => {
        if (response.data.success) {
          this.classList = response.data.data;
          this.targetClassId = this.classList[0].id;
          this.listCourses(this.targetClassId);
        } else {
          this.$notify.error({
            title: '查询教师管理班级失败',
            message: response.data.msg
          });
        }
      });
    },
    // 查询某班级的课程
    listCourses(classId){
      axois.get(`/courseManage/listCourse/${classId}`).then(response=>{
        if (response.data.success) {
          this.courseList = response.data.data;
        } else {
          this.$notify.error({
            title: '查询课程列表失败',
            message: response.data.msg
          });
        }
      });
    }
  }
}
</script>

<style scoped>

</style>