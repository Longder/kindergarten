/**
 * 页面引入
 */

// 主页
const Dashboard = loadVue('/views/dashboard/index.vue');
// 我的数据概览页面
const MyData = loadVue('/views/my-data/index.vue');
// 资源查询页
const ResourceBrowsing = loadVue('/views/resource-browsing/index.vue');
// 共享数据申请表单
const DataApplicationForm = loadVue('/views/data-application-form/index.vue');
// 共享数据详情页
const SharedDataDetail = loadVue('/views/shared-data-detail/index.vue');
// 元数据详情页
const MetadataDetail = loadVue('/views/metadata-detail/index.vue');
// 调用列表查询
const InvokingList = loadVue('/views/invoking-list/index.vue');
// 某共享数据的调用列表
const SharedDataInvokingDetail = loadVue('/views/shared-data-invoking-detail/index.vue');
// 针对某机构的详情
const OrgDataDetail = loadVue('/views/org-data-detail/index.vue');

// 元数据详情页
const SharedDataList = loadVue('/views/shared-data-list/index.vue');
// 数据目录管理页
const DataCatalogManage = loadVue('/views/data-catalog-manage/index.vue');
// 共享数据管理页
const DataShareManage = loadVue('/views/data-share-manage/index.vue');

// 我的申请页
const MyApplication = loadVue('/views/my-application/index.vue');
// 待审核 for 申请
const PreCheckingForApplication = loadVue('/views/my-application/views/PreCheckingList/index.vue');
const CheckedForApplication = loadVue('/views/my-application/views/checkedList/index.vue');
// 数据详情使用页
const DataUsageDetail = loadVue('/views/my-application/views/DataUsageDetail/index.vue');
// 申请详情页
const ApplicationDetail = loadVue('/views/my-application/views/ApplicationDetail/index.vue');

// 我的审核页
const MyChecking = loadVue('/views/my-checking/index.vue');
// 待审核 for 申请
const PreCheckingForChecking = loadVue('/views/my-checking/views/PreCheckingList/index.vue');
const CheckedForChecking = loadVue('/views/my-checking/views/checkedList/index.vue');
// 审核表单
const CheckingForm = loadVue('/views/my-checking/views/CheckingForm/index.vue');
// 审核详情页
const CheckingDetail = loadVue('/views/my-checking/views/CheckingDetail/index.vue');

// 个人中心
const PersonalCenter = loadVue('/views/personal-center/index.vue');
// 基本信息
const BasicInfo = loadVue('/views/personal-center/views/BasicInfo/index.vue');
// 证书管理
const CertificateManage = loadVue('/views/personal-center/views/CertificateManage/index.vue');
// 区块链管理
const ChainInfoEdit = loadVue('/views/personal-center/views/ChainInfoEdit/index.vue');

// 机构管理页
const OrgManage = loadVue('/views/org-manage/index.vue');

// 区块浏览器
const BlockBrowser = loadVue('/views/block-browser/BlockBrowser.vue');

// 交易浏览
const TransactionBrowser = loadVue('/views/block-browser/TransactionBrowser.vue');


/**
 * 全局路由定义
 */
const routes = [
    // 主页
    {path: '/', component: Dashboard},
    // 某机构的数据详情
    {path: '/orgDataDetail', component: OrgDataDetail, name: 'orgDataDetail', props: true},
    // 我的数据
    {path: '/myData', component: MyData},
    // 数据调用查询列表
    {path: '/invokingList', name: 'invokingList', component: InvokingList, props: true},
    // 数据调用查询列表（针对某个共享数据）
    {
        path: '/sharedDataInvokingDetail',
        name: 'sharedDataInvokingDetail',
        component: SharedDataInvokingDetail,
        props: true
    },
    // 资源查询
    {path: '/resourceBrowsing', name: 'resourceBrowsing', component: ResourceBrowsing, props: true},
    // 元数据详情查看
    {path: '/metadataDetail', name: 'metadataDetail', component: MetadataDetail, props: true},
    // 共享数据列表（某个元数据下关联的共享数据列表）
    {path: '/sharedDataList', name: 'sharedDataList', component: SharedDataList, props: true},
    // 数据使用申请表单
    {path: '/dataApplicationForm', name: 'dataApplicationForm', component: DataApplicationForm, props: true},
    // 共享数据详情
    {path: '/sharedDataDetail', name: 'sharedDataDetail', component: SharedDataDetail, props: true},
    // 数据目录管理
    {path: '/dataCatalogManage', component: DataCatalogManage},
    // 共享数据管理
    {path: '/dataShareMange', component: DataShareManage},
    // 我的申请列表
    {
        path: '/myApplication', component: MyApplication,
        children: [
            // 待审列表
            {
                name: 'preCheckingList', path: 'preCheckingList', component: PreCheckingForApplication,
            },
            // 已审列表
            {
                path: 'checkedList', component: CheckedForApplication
            },
            // 使用共享数据详情查看
            {
                name: 'dataUsageDetail', path: 'dataUsageDetail', component: DataUsageDetail, props: true
            },
            // 申请详情查看
            {
                name: 'applicationDetail', path: 'applicationDetail', component: ApplicationDetail, props: true
            }
        ]
    },
    // 我的审核列表
    {
        path: '/myChecking', component: MyChecking,
        children: [
            // 待审列表
            {
                path: 'preCheckingList', component: PreCheckingForChecking,
            },
            // 已审列表
            {
                path: 'checkedList', component: CheckedForChecking
            },
            // 审核操作表单
            {
                path: 'checkingForm', name: 'checkingForm', component: CheckingForm, props: true
            },
            // 审核详情查看
            {
                path: 'checkingDetail', name: 'checkingDetail', component: CheckingDetail, props: true
            }
        ]
    },
    // 个人中心
    {
        path: '/personalCenter', name: 'personalCenter', component: PersonalCenter,
        children: [
            // 基本信息
            {
                path: 'basicInfo', component: BasicInfo,
            },
            // 证书管理
            {
                path: 'certificateManage', component: CertificateManage
            },
            // 区块链信息管理
            {
                path: 'chainInfoEdit', component: ChainInfoEdit
            }
        ]
    },
    // 机构管理
    {
        path: '/orgManage', name: 'orgManage', component: OrgManage
    },
    // 区块浏览器
    {
        path:'/blockBrowser',name:'blockBrowser',component:BlockBrowser
    },
    // 交易浏览
    {
        path:'/transactionBrowser',name:'',component: TransactionBrowser
    }
];

const router = VueRouter.createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: VueRouter.createWebHashHistory(),
    routes, // `routes: routes` 的缩写
});