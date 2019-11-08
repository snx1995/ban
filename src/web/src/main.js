// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import axios from 'axios';

import VueDraggable from 'vuedraggable';
import Ban from './components/ban'

Vue.use(Ban);
Vue.component('VueDraggable', VueDraggable);

Vue.config.productionTip = false;

Vue.prototype.$net = axios;

initAxios();
/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>'
});

function initAxios() {
    axios.defaults.baseURL = '/rest';
    axios.interceptors.response.use(response => {
        if (response.status < 300) {
            if (response.data) {
                const data = response.data;
                switch (data.code) {
                    case -1:
                        Ban.messager.error(`${data.msg} -> ${data.data}`);
                    break;
                    case 0:
                        return response.data;
                    break;
                    case 1:
                        Ban.messager.error('用户验证失败，请重新登陆!');
                    break;
                    case 2:
                        Ban.messager.error(`参数错误 -> ${data.data}`);
                    break;
                }
                return false;
            }
            else throw new Error(response.data && response.data.msg);
        } else return response;
    })
}
