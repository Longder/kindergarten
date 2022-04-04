/**
 * 页面引入
 */

// 主页
const Index = loadVue('/views/index/index.vue');
// 活动天地
const Activity = loadVue('/views/activity/index.vue');
// 班级和用户管理页
const ClassGradeAndUserManage = loadVue('/views/class-grade-and-user-manage/index.vue');
// 班级管理
const ClassGradeManage = loadVue('views/class-grade-and-user-manage/views/ClassGradeManage/index.vue');
// 用户管理
const UserManage = loadVue('views/class-grade-and-user-manage/views/UserManage/index.vue');


/**
 * 全局路由定义
 */
const routes = [
    // 主页
    {path: '/', component: Index},
    // 活动天地
    {path:'/activity',component:Activity},
    // 班级和用户管理
    {path:'/classGradeAndUserManage',component:ClassGradeAndUserManage,
        children: [
            // 用户管理
            {
                name: 'userManage', path: 'userManage', component: UserManage,
            },
            // 班级管理
            {
                name: 'classGradeManage', path: 'classGradeManage', component: ClassGradeManage,
            },
        ]}
];

const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes, // `routes: routes` 的缩写
});