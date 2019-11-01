//components
import {BButton, BButtonGroup} from './components/button';
import BSwitch from './components/switch';
import {BCheckbox, BCheckboxGroup} from './components/checkbox';
import {BRadio, BRadioGroup} from './components/radio';
import {BInput} from './components/input';
import {BForm, BFormItem} from './components/form';
import {BGrid, BGridRow, BGridItem} from './components/grid';

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

    vue.prototype.$ban = {
        changeTheme(theme) {
            
        }
    }
}

if (window && window.Vue) install(window.Vue)

export default {
    ...components,
    install
}