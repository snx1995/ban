<template>
    <div class="test">
        <i class="fa fa-fan"></i>
    </div>
</template>
<script>
import axios from "axios";
export default {
    name: "Test",
    data() {
        return {};
    },
    mounted() {
        this.$net.post("/auth/login", {
            account: "exception",
            password: "banyq"
        }).then(res => {
            axios.defaults.headers["Authorization"] = res.data.token;
        }).catch(err => {
            console.log(err);
        })
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
