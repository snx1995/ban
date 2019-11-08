<template>
    <div class="test" v-bloading="loading">
        <!-- <i class="fa fa-fan"></i> -->
        <BInput v-model="msg"/>
        <BButton @click="handleNewMsg">msg</BButton>
        <BButton @click="handleNewConfirm">confirm</BButton>
        <BButton @click="handleLoading">loading</BButton>
        <div>
            <h1>Error test</h1>
            <BButton @click="errorHandle('success')">success</BButton>
            <BButton @click="errorHandle('error')">error</BButton>
            <BButton @click="errorHandle('auth')">auth</BButton>
            <BButton @click="errorHandle('param')">param</BButton>
            <BButton @click="errorHandle('404')">404</BButton>
        </div>
    </div>
</template>
<script>
let count = 0;
import axios from "axios";
export default {
    name: "Test",
    data() {
        return {
            msg: 'default',
            loading: false
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
