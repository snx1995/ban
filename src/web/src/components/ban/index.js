import {BButton, BButtonGroup} from './button';
import BSwitch from './switch';
import {BCheckbox, BCheckboxGroup} from './checkbox';
import {BRadio, BRadioGroup} from './radio';

const components = {
    BButton,
    BButtonGroup,
    BSwitch,
    BCheckbox,
    BCheckboxGroup,
    BRadio,
    BRadioGroup
}

const directives = {

}

const install = (vue, opts = {}) => {
    if (install.installed) return;
    Object.keys(components).forEach(key => {
        vue.component(key, components[key])
    })
}

if (window && window.Vue) install(window.Vue)

export default {
    ...components,
    install
}