export default {
    state: {
        name: 'test',
        count: 0
    },
    mutations: {
        incCount(state) {
            state.count ++;
        },
        changeName(state, name) {
            state.name = name;
        }
    },
    actions: {
        changeName(context, name) {
            context.commit('changeName', name);
        },
        incCount(context) {
            context.commit('incCount');
        },
        asyncChangeName(context, name, delay) {
            setTimeout(() => {
                context.commit('changeName', name);
            }, delay);
        }
    },
    getters: {
        hello(state) {
            return `Hello ${state.name}`;
        }
    }
}