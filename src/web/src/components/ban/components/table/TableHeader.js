export default {
    name: 'BTableHeader',
    functional: true,
    props: {
        def: {
            type: Object,
            default() {
                return {};
            }
        }
    },
    render(h, ctx) {
        const {def} = ctx.props;
        return h('h2', def.title);
    }
}