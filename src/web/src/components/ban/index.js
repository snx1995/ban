//components
import {BButton, BButtonGroup} from './components/button';
import BSwitch from './components/switch';
import {BCheckbox, BCheckboxGroup} from './components/checkbox';
import {BRadio, BRadioGroup} from './components/radio';
import {BInput} from './components/input';
import {BForm, BFormItem} from './components/form';
import {BGrid, BGridRow, BGridItem} from './components/grid';
import {BMessageContainer} from './components/message';
import {Confirm} from './components/confirm';

// directives
import Bloading from './directives/loading';

const components = {
    BButton,
    BButtonGroup,
    BSwitch,
    BCheckbox,
    BCheckboxGroup,
    BRadio,
    BRadioGroup,
    BInput,
    BForm,
    BFormItem,
    BGrid,
    BGridRow,
    BGridItem
}

const directives = {
    Bloading
}

const install = (vue, opts = {}) => {
    if (install.installed) return;
    Object.keys(components).forEach(key => {
        vue.component(key, components[key])
    })

    Object.keys(directives).forEach(key => {
        const directive = directives[key];
        vue.directive(directive.name, directive);
    })
    
    vue.prototype.$confirm = Confirm;
    vue.prototype.$ban = {
        changeTheme(theme) {
            
        }
    }

    initMessageContainer();

    function initMessageContainer() {
        let index = 1;
        const mcf = vue.extend(BMessageContainer);
        const mc = new mcf();
        function messager(msg) {
            msg.id = index ++;
            mc.$data.msgs.unshift(msg);
        }

        vue.prototype.$msg = messager;

        messager.success = message => {
            messager({
                type: 'success',
                message
            })
        }
        messager.warning = message => {
            messager({
                type: 'warning',
                message
            })
        }
        messager.info = message => {
            messager({
                type: 'info',
                message
            })
        }
        messager.error = message => {
            messager({
                type: 'error',
                message
            })
        }
        document.body.appendChild(mc.$mount().$el);
    }
}

if (window && window.Vue) install(window.Vue)

export default {
    ...components,
    install
}