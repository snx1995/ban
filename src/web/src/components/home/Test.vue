<template>
    <div class="test" v-bloading="loading">
        <div class="center">
            <div style="width: 600px;">
                <BUpload />
            </div>
            <div class="img-test">
                <img v-for="(img, index) in imgs" :src="img" :key="index" :class="{active: activeImg == index}" @mouseenter="activeImg = index">
            </div>
        </div>
    </div>
</template>
<script>
    let count = 0;
    export default {
        name: "Test",
        data() {
            return {
                msg: 'default',
                loading: false,
                progress: 10,
                colsDef: [
                    {
                        type: 'selection',
                        width: '50'
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
                ],
                imgSrc: '',
                imgs: [
                    "../../../static/imgs/1.jpg",
                    "../../../static/imgs/2.jpg",
                    "../../../static/imgs/3.jpg",
                    "../../../static/imgs/4.jpg"
                ],
                activeImg: 0
            };
        },
        mounted() {
            console.log('name', this.$store.state.TestModule.name)
            console.log('count', this.$store.state.TestModule.count)
            this.$store.commit('changeName', 'banyq');
            this.$store.commit('incCount');
            console.log('name', this.$store.state.TestModule.name)
            console.log('count', this.$store.state.TestModule.count)
            this.$store.dispatch('changeName', 'banyq');
            this.$store.dispatch('incCount');
            console.log('name', this.$store.state.TestModule.name)
            console.log('count', this.$store.state.TestModule.count)
            const delay = 500;
            this.$store.dispatch('asyncChangeName', 'async banyq', delay);
            console.log('name', this.$store.state.TestModule.name)
            setTimeout(() => {
                console.log('async', this.$store.state.TestModule.name)
            }, delay)
            console.log(this.$store.getters.hello)
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
<style scoped lang="less">
    .fa-fan {
        font-size: 64px;
        color: white;
        animation: rotate 1s infinite linear;
    }
    .test {
        background-color: #fff;
        padding: 100px 0;
        text-align: left;
        .center {
            width: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    }
    .img-test {
        width: 100%;
        height: 200px;
        img {
            width: 20%;
            height: 100%;
            transition: width .3s;
            &.active {
                width: 40%;
            }
        }
    }
</style>
