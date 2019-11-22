<template>
    <div class="b-video">
        <video :src="src" controls autoplay></video>
    </div>
</template>
<script>
    export default {
        name: "BVideo",
        props: ['resourceId'],
        data() {
            return {}
        },
        computed: {
            src() {
                return `/rest/resource/get?id=${this.resourceId}`;
            }
        },
    }
</script>
<style scoped lang="less">
.b-video {
    width: 100%;
    height: 100%;
    video {
        width: 100%;
        height: 100%;
    }
}
</style>
