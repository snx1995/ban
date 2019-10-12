import {BButton, BButtonGroup} from './button';
import BSwitch from './switch';
import {BCheckbox, BCheckboxGroup} from './checkbox';
import {BRadio, BRadioGroup} from './radio';
import {BInput} from './input';
import {BForm, BFormItem} from './form';
import {BGrid, BGridRow, BGridItem} from './grid';

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

}

const install = (vue, opts = {}) => {
    if (install.installed) return;
    Object.keys(components).forEach(key => {
        vue.component(key, components[key])
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