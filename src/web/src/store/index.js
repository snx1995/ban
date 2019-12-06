import Vuex from 'vuex';
import TestModule from './test';
import Vue from 'vue';

Vue.use(Vuex);
export default new Vuex.Store({
    modules: {
        TestModule
    }
})