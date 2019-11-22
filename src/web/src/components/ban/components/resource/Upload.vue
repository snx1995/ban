<template>
    <div class="b-upload">
        <form ref="uploadForm" action="/rest/resource/upload" method="post" enctype="multipart/form-data" onsubmit="return false;">
            <label for="FilesUpload" class="upload-btn" @click="handleAddFileClick">
                上传
                <input ref="filesInput" type="file" multiple name="files" id="filesUpload" @change="handleFilesChange">
            </label>
<!--            <input type="submit">-->
            <BButton @click="handleUpload">上传</BButton>
        </form>
    </div>
</template>

<script>
    export default {
        name: "Upload",
        data() {
            return {
                fileList: []
            };
        },
        methods: {
            handleUpload() {
                const formData = new FormData();
                console.log(this.fileList)
                if (this.fileList.length > 0) {
                    this.fileList.forEach(e => {
                        formData.append('files', e);
                    })
                    this.$net.post('/resource/upload', formData).then(res => {
                        console.log(res);
                    })
                }
            },
            handleAddFileClick() {
                this.$refs.filesInput.click();
            },
            handleFilesChange(event) {
                const files = event.target.files;
                for (let i = 0;i < files.length;i ++) {
                    this.fileList.push(files[i]);
                }
            }
        }
    }
</script>
<style scoped lang="less">
.b-upload {
    width: 100%;
    .upload-btn {
        display: block;
        width: 100%;
        height: 50px;
        border: 1px solid #333;
    }
}
#filesUpload {
    display: none;
}
</style>
