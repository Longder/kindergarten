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

// 教师用管理页
const ManageForTeacher = loadVue('views/manage-for-teacher/index.vue');
// 活动管理
const ActivityManage = loadVue('views/manage-for-teacher/views/ActivityManage/index.vue');
// 课程管理
const CourseManage = loadVue('views/manage-for-teacher/views/ActivityManage/index.vue');
// 饮食管理
const DietManage = loadVue('views/manage-for-teacher/views/DietManage/index.vue');

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
        ]},
    // 老师用管理页
    {path:'/teacher',component: ManageForTeacher,children: [
            // 活动管理
            {
                name:'activityManage',path:'activityManage',component:ActivityManage
            },
            // 每日所学管理
            {
                name:'courseManage',path:'courseManage',component:CourseManage
            },
            // 班级饮食管理
            {
                name:'dietManage',path:'dietManage',component:DietManage
            },
        ]}
];

const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes, // `routes: routes` 的缩写
});