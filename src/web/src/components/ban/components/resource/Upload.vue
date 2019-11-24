<template>
    <div class="b-upload" v-bloading="loading">
        <form ref="uploadForm" action="/rest/resource/upload" method="post" enctype="multipart/form-data" onsubmit="return false;">
            <input ref="filesInput" type="file" multiple name="files" id="filesUpload" @input="handleFilesInput">
            <div class="file-item-list">
                <BFileItem v-for="(item, index) in fileList" :file="item" :key="index" :type="listStyle" @remove="fileList.splice(index, 1)"/>
            </div>
            <div class="op-group">
                <i class="icon-folder" @click="handleAddFileClick"></i>
                <i class="icon-upload" @click="handleUpload"></i>
                <i class="icon-bin" @click="handleFileClear"></i>
                <i class="icon-cog setting">
                    <label>
                        <input type="checkbox">
                        <ul>
                            <li>
                                <span class="setting-icon">显示：</span>
                                <i class="list-style icon-th-large" @click="listStyle = 'card'" :class="{active: listStyle == 'card'}"></i>
                                <i class="list-style icon-th-list" @click="listStyle = 'list'" :class="{active: listStyle == 'list'}"></i>
                            </li>
                            <li>
                                <span class="setting-icon">图片压缩：</span>
                                <BSwitch size="sm" v-model="picCompress"/>
                            </li>
                        </ul>
                    </label>
                </i>
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
                fileList: [],
                loading: false,
                picCompress: true,
                listStyle: 'card' // card, list
            };
        },
        methods: {
            handleUpload() {
                if (this.fileList.length == 0) return;
                const formData = new FormData();
                console.log(this.fileList)
                this.loading = true;
                setTimeout(() => {
                    this.loading = false;
                }, 2000);
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
            handleFilesInput(event) {
                const files = event.target.files;
                for (let i = 0;i < files.length;i ++) {
                    this.fileList.push(files[i]);
                }
            },
            handleFileClear() {
                this.fileList = []
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
        max-height: 400px;
        display: flex;
        flex-wrap: wrap;
        padding: 10px;
        overflow: auto;
    }
    .op-group {
        width: 100%;
        height: 2em;
        line-height: 2em;
        border-top: 1px dashed @fontColorGrey;
        display: flex;
        justify-content: flex-end;
        > i {
            // .btnLike();
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
            &.setting {
                > label {
                    position: relative;
                    display: inline-block;
                    width: 100%;
                    height: 100%;
                    ul {
                        position: absolute;
                        bottom: 120%;
                        right: 0;
                        list-style: none;
                        display: none;
                        width: 150px;
                        background-color: white;
                        box-shadow: 0 6px 12px rgba(7, 17, 27, .3);
                        li {
                            padding: 5px 2px;
                            cursor: pointer;
                            span {
                                font-size: 12px;
                                display: inline-block;
                                width: 60px;
                                text-align: right;
                            }
                            .list-style {
                                &.active {
                                    color: @success;
                                }
                            }
                        }
                        &::before {
                            content: "";
                            display: block;
                            width: 0;
                            height: 0;
                            border: 10px solid transparent;
                            border-top-color: white;
                            position: absolute;
                            top: 100%;
                            right: 7px;
                        }
                    }
                    input {
                        display: none;
                    }
                    input:checked + ul {
                        display: block;
                    }
                }
            }
        }
    }
}
#filesUpload {
    display: none;
}
</style>
