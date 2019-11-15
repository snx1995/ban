<template>
    <div class="test" v-bloading="loading">
        <BTable :colsDef="colsDef" :data="data">
            <template v-slot:memo="row">
                <span style="color: red">{{row.memo}}</span>
            </template>
        </BTable>
    </div>
</template>
<script>
import ComponentTest from './ComponentTest';
let count = 0;
export default {
    name: "Test",
    components: {
        ComponentTest
    },
    data() {
        return {
            msg: 'default',
            loading: false,
            progress: 10,
            colsDef: [
                {
                    type: 'selection'
                },
                {
                    type: 'index',
                    title: 'index'
                },
                {
                    title: 'title',
                    key: 'title'
                },
                {
                    type: 'render',
                    title: 'render',
                    render(h, row) {
                        return h('h1', row.name);
                    }
                },
                {
                    title: 'slot',
                    type: 'slot',
                    slot: 'memo'
                }
            ],
            data: [
                {title: 't1', name: 'n1', memo: 'test1'},
                {title: 't2', name: 'n2', memo: 'test2'},
                {title: 't3', name: 'n3', memo: 'test3'},
                {title: 't4', name: 'n4', memo: 'test4'}
            ]
        };
    },
    mounted() {

    },
    methods: {
        handleNewMsg() {
            switch (count++ % 4) {
                case 0:
                    this.$msg.success(this.msg);
                    break;
                case 1:
                    this.$msg.info(this.msg);
                    break;
                case 2:
                    this.$msg.warning(this.msg);
                    break;
                case 3:
                    this.$msg.error(this.msg);
                    break;
            }
        },
        handleNewConfirm() {
            this.$confirm({
                title: 'Hello world',
                prompt: 'testasdasdadqweqwadsdqweqe asd a zx asdasd zxc zxc zc z zc zxc z'
            }).then(() => {
                console.log('confirm');
            }).catch(err => {
                console.log(err);
                console.log('cancel');
            })
        },
        handleLoading() {
            this.loading = true;
            setTimeout(() => this.loading = false, 2000);
        },
        errorHandle(type) {
            let url;
            if (type == '404') url = '/rest/a';
            else url = `/test/errorType?type=${type}`;
            this.$net.get(url).then(res => {
                if (res) this.$msg.success(res.data);
            })

        }
    }
};
</script>
<style scoped>
.fa-fan {
    font-size: 64px;
    color: white;
    animation: rotate 1s infinite linear;
}
.test {
    background-color: #fff;
    padding: 100px 0;
    text-align: left;
}
</style>
