<template>
    <div class="b-table">
        <table>
            <thead>
                <tr class="b-table-title">
                    <th v-for="(col, index) in colsDef" :key="index">
                        <TableHeader :def='col'/>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(row, index) in data" :key="index">
                    <td v-for="(col, index2) in colsDef" :key="index2">
                        <TableCell :def='col' :row="row" :index="index + 1"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
import TableCell from './TableCell';
import TableHeader from './TableHeader';
export default {
    name: 'BTable',
    props: {
        colsDef: {
            type: Array,
            default: []
        },
        data: {
            type: Array,
            default: []
        }
    },
    components: {
        TableCell,
        TableHeader
    },
    provide() {
        return {
            tableRoot: this
        }
    },
    data () {
        return {

        }
    },
    mounted() {
        console.log('scopedSlots', this.$scopedSlots)
    },
}
</script>
<style lang="less" scoped>
.b-table {
    .borderBox();
    width: 100%;
    height: 100%;
}
</style>