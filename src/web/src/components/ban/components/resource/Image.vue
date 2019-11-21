<template>
    <div class="img-wrapper">
        <img :src="src" alt="" v-if="src">
        <span v-if="!src">error</span>
    </div>
</template>
<script>
    export default {
        name: "BImage",
        props: ["imgId"],
        computed: {
            src() {
                if (this.imgId) {
                    return `/rest/resource/get?id=${this.imgId}`;
                } else return false;
            }
        }
    }
</script>
<style scoped lang="less">
    .img-wrapper {
        width: 100%;
        height: 100%;
        img {
            width: 100%;
            height: auto;
        }
    }
</style>
