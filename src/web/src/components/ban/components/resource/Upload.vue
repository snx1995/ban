<template>
    <div class="b-upload">
        <form ref="uploadForm" action="/rest/resource/upload" method="post" enctype="multipart/form-data" onsubmit="return false;">
            <input ref="filesInput" type="file" multiple name="files" id="filesUpload" @change="handleFilesChange">
            <div class="file-item-list">
                <BFileItem v-for="(item, index) in fileList" :file="item" :key="index"/>
            </div>
            <div class="op-group">
                <i class="icon-folder" @click="handleAddFileClick"></i>
                <i class="icon-upload" @click="handleUpload"></i>
                <i class="icon-cog"></i>
            </div>
        </form>
    </div>
</template>
<script>
    import BFileItem from './FileItem';
    export default {
        name: "Upload",
        components: {
            BFileItem
        },
        data() {
            return {
                fileList: []
            };
        },
        methods: {
            handleUpload() {
                const formData = new FormData();
                console.log(this.fileList)
                // if (this.fileList.length > 0) {
                //     this.fileList.forEach(e => {
                //         formData.append('files', e);
                //     })
                //     this.$net.post('/resource/upload', formData).then(res => {
                //         console.log(res);
                //     })
                // }
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
    border: 1px dashed @fontColorGrey;
    border-radius: 5px;
    .file-item-list {
        .borderBox();
        min-height: 50px;
        display: flex;
        flex-wrap: wrap;
        padding: 10px;
    }
    .op-group {
        width: 100%;
        height: 2em;
        line-height: 2em;
        border-top: 1px dashed @fontColorGrey;
        display: flex;
        justify-content: flex-end;
        i {
            font-size: 1.2em;
            position: relative;
            display: block;
            width: 2em;
            cursor: pointer;
            &:not(:last-child) {
                border-right: 1px dashed @fontColorGrey;
            }
            &::before {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
        }
    }
}
#filesUpload {
    display: none;
}
</style>
