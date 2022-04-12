<template>
  <el-card>
    <el-divider><h3>班级饮食管理</h3></el-divider>
    <el-form :inline="true">
      <el-form-item label="班级查询：">
        <el-select v-model="targetClassId">
          <el-option label="一班" value="1" />
          <el-option label="二班" value="2" />
        </el-select>
      </el-form-item>
      <el-button type="primary">添加饮食内容</el-button>
    </el-form>
    <el-table
        border
        :data="activityList"
        style="width: 100%">
      <el-table-column prop="id" label="编号" width="50"/>
      <el-table-column prop="classGrade" label="班级" />
      <el-table-column prop="date" label="日期" />
      <el-table-column prop="date" label="饮食类型" >
        <template #default="scope">
          <el-tag>{{ scope.row.name }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="address" label="饮食内容" width="700"/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="warning" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script>
export default {
  name: "DietManage",
  data(){
    return {
      // 班级列表
      classList:[],
      // 目标班级id（正在查询）
      targetClassId:'1',
      // 活动列表
      activityList:[
        {
          id:1,
          date: '2021-05-03',
          name: '午餐',
          classGrade:'一班',
          address: '饮食内容内容xxxxx',
        },
        {
          id:2,
          date: '2021-05-02',
          name: '午餐',
          classGrade:'一班',
          address: '饮食内容内容xxxxx',
        },
        {
          id:3,
          date: '2021-05-04',
          name: '午餐',
          classGrade:'一班',
          address: '饮食内容内容xxxxx',
        },
        {
          id:4,
          date: '2021-05-01',
          name: '午餐',
          classGrade:'一班',
          address: '饮食内容内容xxxxx',
        },
        {
          id:5,
          date: '2021-05-08',
          name: '午餐',
          classGrade:'一班',
          address: '饮食内容内容xxxxx',
        },
        {
          id:6,
          date: '2021-05-06',
          name: '午餐',
          classGrade:'一班',
          address: '饮食内容内容xxxxx',
        },
        {
          id:7,
          date: '2021-05-07',
          name: '午餐',
          classGrade:'一班',
          address: '饮食内容内容xxxxx',
        },
      ]
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
          this.activityList = response.data.data;
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