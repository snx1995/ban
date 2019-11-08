import Vue from 'vue';
import BLoading from './Loading';

/**
 * binding 参数属性
 *  name：指令名，不包括 v- 前缀。
 *  value：指令的绑定值，例如：v-my-directive="1 + 1" 中，绑定值为 2。
 *  oldValue：指令绑定的前一个值，仅在 update 和 componentUpdated 钩子中可用。无论值是否改变都可用。
 *  expression：字符串形式的指令表达式。例如 v-my-directive="1 + 1" 中，表达式为 "1 + 1"。
 *  arg：传给指令的参数，可选。例如 v-my-directive:foo 中，参数为 "foo"。
 *  modifiers：一个包含修饰符的对象。例如：v-my-directive.foo.bar 中，修饰符对象为 { foo: true, bar: true }。
 */
const Loading = Vue.extend(BLoading);

export default {
    name: 'bloading',
    bind(el, binding) {
        const load = new Loading()
        if (el.style.position == '' || el.style.position == 'static') {
            el.style.position = 'relative';
        }
        const lel = load.$mount().$el;
        load.loading = !!binding.value;
        el.loadEl = lel;
        el.appendChild(lel);
        el.instance = load;
    },
    update(el, binding) {
        if (binding.value !== binding.oldValue) {
            el.instance.loading = !!binding.value;
        }
    },
    unbind(el) {
        console.log(111);
        el.loadEL && el.loadEl.remove();
        el.instance && el.instance.$destroy();
    }
}
