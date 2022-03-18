// 初始化 Vue 3 Loader
const loaderOptions = {
    moduleCache: {
        vue: Vue
    },
    async getFile(url) {
        const res = await fetch(url);
        if (!res.ok)
            throw Object.assign(new Error(res.statusText + ' ' + url), {res});
        return await res.text();
    },
    addStyle(textContent) {
        const style = Object.assign(document.createElement('style'), {textContent});
        const ref = document.head.getElementsByTagName('style')[0] || null;
        document.head.insertBefore(style, ref);
    },
};
const {loadModule} = window['vue3-sfc-loader'];

/**
 * 自定义加载Vue组件的方法
 */
const loadVue = (componentUrl) => {
    return Vue.defineAsyncComponent(() => loadModule(componentUrl, loaderOptions))
};