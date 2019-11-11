export default {
    render(createElement) {
        this.$slots.default.forEach(e => {
            console.log(e);
        })

        return createElement(
            this.el,
            this.$slots.default
        )
    },
    props: {
        el: {
            type: String,
            default: 'div'
        }
    }
}