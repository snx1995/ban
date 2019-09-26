import BButton from './button';
import BSwitch from './switch';
import BCheckbox from './checkbox';
import BRadio from './radio';

const components = {
    BButton,
    BSwitch,
    BCheckbox,
    BRadio
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