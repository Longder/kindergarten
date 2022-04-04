<!--主页-->
<template>
  <el-main style="width: 100%;margin: 0 auto;">
    <el-row :gutter="40" style="margin: 0;width: 100%;">
      <el-col :span="21" style="margin: 20px auto 0;">
        <el-row :gutter="40">
          <el-col :span="12">
            <el-card>
              <template #header>
                <div class="card-header">
                  <span>幼儿园统计</span>
                </div>
              </template>
              <div>
                统计图表bulabula
              </div>
            </el-card>
          </el-col>
          <el-col :span="12">
            <el-card>
              <template #header>
                <div class="card-header">
                  <span>小日历</span>
                </div>
              </template>
              <div>
                日历bulabula
              </div>
            </el-card>
          </el-col>
          <el-col :span="24" style="margin-top: 30px;">
            <el-card title="公告">
              <el-timeline>
                <el-timeline-item center timestamp="2018/4/12" placement="top">
                  <el-card>
                    <h4>Update Github template</h4>
                    <p>Tom committed 2018/4/12 20:46</p>
                  </el-card>
                </el-timeline-item>
                <el-timeline-item timestamp="2018/4/3" placement="top">
                  <el-card>
                    <h4>Update Github template</h4>
                    <p>Tom committed 2018/4/3 20:46</p>
                  </el-card>
                </el-timeline-item>
                <el-timeline-item center timestamp="2018/4/2" placement="top">
                  Event start
                </el-timeline-item>
                <el-timeline-item timestamp="2018/4/2" placement="top">
                  Event end
                </el-timeline-item>
              </el-timeline>
            </el-card>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </el-main>
</template>
<script>
export default {
  name: 'Index',
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
  methods: {}
}
</script>