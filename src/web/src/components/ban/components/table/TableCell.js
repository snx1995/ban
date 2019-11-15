export default {
    name: 'TabelCell',
    inject: ['tableRoot'],
    functional: true,
    props: {
        def: {
            type: Object,
            default() {
                return {};
            }
        },
        row: {
            type: Object,
            default() {
                return {};
            }
        },
        index: Number,
        header: {
            type: Boolean,
            default: false
        }
    },
    render(h, ctx) {
        const {def, row, header, index} = ctx.props;
        switch (def.type) {
            case 'selection':
                return h('div', 'sel');
            case 'index':
                return h('div', index);
            case 'render':
                return def.render(h, row);
            case 'slot':
                console.log('asdasd', ctx.injections.tableRoot);
                return h('div', ctx.injections.tableRoot.$scopedSlots[def.slot](row));
        }
        return h('div', {class: 'b-table-cell'}, row[def.key]);
    }
}