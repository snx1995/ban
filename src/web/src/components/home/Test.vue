<template>
    <div class="test">
        <i class="fa fa-fan"></i>
        <BInput v-model="msg"/>
        <BButton @click="handleNewMsg">msg</BButton>
    </div>
</template>
<script>
import axios from "axios";
export default {
    name: "Test",
    data() {
        return {
            msg: 'default'
        };
    },
    mounted() {
        // this.$net.post("/auth/login", {
        //     account: "exception",
        //     password: "banyq"
        // }).then(res => {
        //     axios.defaults.headers["Authorization"] = res.data.token;
        // }).catch(err => {
        //     console.log(err);
        // })
    },
    methods: {
        handleNewMsg() {
            this.$msg.success(this.msg)
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
</style>
