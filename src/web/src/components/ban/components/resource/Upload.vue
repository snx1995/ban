<template>
    <div class="b-upload">
        <form ref="uploadForm" action="/rest/resource/upload" method="post" enctype="multipart/form-data" onsubmit="return false;">
            <input ref="files" type="file" multiple name="files">
<!--            <input type="submit">-->
            <BButton @click="handleUpload">上传</BButton>
        </form>
    </div>
</template>

<script>
    export default {
        name: "Upload",
        data() {
            return {};
        },
        methods: {
            handleUpload() {
                const formData = new FormData(this.$refs.uploadForm);
                console.log(this.$refs.files.files);
                this.$net.post('/resource/upload', formData).then(res => {
                    console.log(res);
                })
            }
        }
    }
</script>

<style scoped>

</style>
