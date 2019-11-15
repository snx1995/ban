<template>
    <div class="b-table" :class="tableClass" v-if="header">
        <table class="b-table-header" border="1">
            <colgroup>
                <col v-for="(col, index) in colStyle" :key="index" :width="col.width">
            </colgroup>
            <thead>
                <tr>
                    <th v-for="(col, index) in colsDef" :key="index">
                        <TableHeader :def='col'/>
                    </th>
                </tr>
            </thead>
        </table>
        <table class="b-table-body" border="1">
            <colgroup>
                <col v-for="(col, index) in colStyle" :key="index" :width="col.width">
            </colgroup>
            <tbody>
                <tr v-for="(row, index) in data" :key="index">
                    <td v-for="(col, index2) in colsDef" :key="index2">
                        <TableCell :def='col' :row="row" :index="index + 1"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <table class="b-table-footer" v-if="footer" border="1">
            <colgroup>
                <col v-for="(col, index) in colStyle" :key="index" :width="col.width">
            </colgroup>
            <tfoot>
                <tr>
                    <td v-for="(col, index) in colsDef" :key="index">
                        <TableCell :def='col'/>
                    </td>
                </tr>
            </tfoot>
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
        },
        border: Boolean,
        highlight: Boolean,
        header: {
            type: Boolean,
            default: true
        },
        footer: Boolean
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
        
    },
    computed: {
        tableClass() {
            return {
                border: this.border,
                highlight: this.highlight
            }
        },
        colStyle() {
            return this.colsDef.map(e => {
                return {
                    width: e.width != undefined ? e.width : '1*'
                }
            })
        }
    }
}
</script>
<style lang="less" scoped>
.b-table {
    .borderBox();
    width: 100%;
    height: 100%;
    table {
        width: 100%;
        border-collapse: collapse;
        &.b-table-body  {
            // border-top: none;
            // border-bottom: none;
        }
    }

}
</style>