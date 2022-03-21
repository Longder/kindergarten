/**
 * 页面引入
 */

// 主页
const Index = loadVue('/views/index/index.vue');
// 活动天地
const Activity = loadVue('/views/activity/index.vue');
// 班级管理页
const ClassManage = loadVue('/views/class-manage/index.vue');


/**
 * 全局路由定义
 */
const routes = [
    // 主页
    {path: '/', component: Index},
    // 活动天地
    {path:'/activity',component:Activity},
    // 班级管理
    {path:'/classManage',component:ClassManage}
];

const router = VueRouter.createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: VueRouter.createWebHashHistory(),
    routes, // `routes: routes` 的缩写
});