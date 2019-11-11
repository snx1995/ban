import BConfirm from './Confirm';
import Vue from 'vue';

const Conf = Vue.extend(BConfirm);
function Confirm(option = {}) {
    return new Promise((resolve, reject) => {
        const instance = new Conf({
            propsData: {
                onConfirm() {
                    destroy();
                    resolve();
                },
                onCancel() {
                    destroy();
                    reject('canceled');
                },
                title: option.title,
                prompt: option.prompt
            }
        });
        const el = instance.$mount().$el;
        document.body.appendChild(el);

        function destroy() {
            instance.$destroy();
            el.remove();
        }
    })
} 

export {Confirm};