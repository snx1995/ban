<template>
    <div class="test"></div>
</template>

<script>
  import axios from 'axios';
    export default {
        name: "Test",
        data() {
            return {

            }
        },
        mounted() {
            this.$net.post('/auth/login', {
                account: '12312',
                password: 'banyq'
            }).then(res => {
                if (res.code === 0) {
                    axios.defaults.headers['Authorization'] = res.data.token;
                }
            })
        }
    }
</script>

<style scoped>

</style>
