export default {
    name: 'ComponentTest',
    functional: true,
    render (h, ctx) {
        console.log(ctx);
        return h(ctx.props.tag, {
            class: 'b-component-test'
        }, ctx.slots.default)
    },
    props: {
        tag: {
            type: String,
            default: 'div'
        }
    }
}