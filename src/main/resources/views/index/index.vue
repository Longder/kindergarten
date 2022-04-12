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
            <el-card>
              <template #header>
                <div class="card-header">
                  <span>每日所学</span>
                </div>
              </template>
              <el-timeline>
                <el-timeline-item center timestamp="2022/4/12" placement="top">
                  <el-card>
                    <h4>学习使用饭勺</h4>
                    <el-space>
                      <el-image style="width: 100px; height: 100px" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" fit="fill" />
                      <p>啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦</p>
                    </el-space>
                    <p>赵老师 发布于 2022/4/12 20:46</p>
                  </el-card>
                </el-timeline-item>
                <el-timeline-item timestamp="2022/4/3" placement="top">
                  <el-card>
                    <h4>学习使用饭勺</h4>
                    <el-space>
                      <el-image style="width: 100px; height: 100px" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" fit="fill" />
                      <p>啦啦啦啦啦啦啦啦啦</p>
                    </el-space>
                    <p>赵老师 发布于 2022/4/12 20:46</p>
                  </el-card>
                </el-timeline-item>
                <el-timeline-item center timestamp="2022/4/2" placement="top">
                  <el-card>
                    <h4>学习使用饭勺</h4>
                    <el-space>
                      <el-image style="width: 100px; height: 100px" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" fit="fill" />
                      <p>啦啦啦啦啦啦啦啦啦</p>
                    </el-space>
                    <p>赵老师 发布于 2022/4/12 20:46</p>
                  </el-card>
                </el-timeline-item>
                <el-timeline-item timestamp="2022/4/2" placement="top">
                  <el-card>
                    <h4>学习使用饭勺</h4>
                    <el-space>
                      <el-image style="width: 100px; height: 100px" src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg" fit="fill" />
                      <p>啦啦啦啦啦啦啦啦啦</p>
                    </el-space>
                    <p>赵老师 发布于 2022/4/12 20:46</p>
                  </el-card>
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