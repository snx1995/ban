<template>
    <div class="b-file-item" :class="[theme, type]">
        <div class="file-content">
            <i :class="iconClass"></i>
            <span class="file-name">{{file.name}}</span>
        </div>
        <div class="file-info">
            <span class="file-size">{{fileSize}}</span>
            <span class="file-date">{{new Date(file.lastModified).format('yyyy-MM-dd hh-mm')}}</span>
        </div>
    </div>
</template>
<script>
const fileSizeUnit = 'BKMG';
export default {
    name: 'BFileItem',
    props: {
        theme: {
            type: String,
            default: 'default'
        },
        type: {
            type: String,
            default: 'card'
        },
        file: File
    },
    data() {
        return {}
    },
    computed: {
        iconClass() {
            const type = this.file ? this.file.type : 'unknown';
            switch (true) {
                case type == 'application/x-msdownload':
                    return 'icon-drive';
                case type == 'application/zip':
                    return 'icon-file-zip';
                case type.startsWith('image'):
                    return 'icon-file-picture';
                case type.startsWith('video'):
                    return 'icon-file-video';
                case type.startsWith('audio'):
                    return 'icon-file-music';
                default:
                    return 'icon-file-empty';
            }
        },
        fileSize() {
            let size = this.file.size;
            for (let i = 0;i < fileSizeUnit.length;i ++) {
                if (size < 1024) return size.toFixed(2) + fileSizeUnit.charAt(i);
                size /= 1024;
            }
        }
    }
}
</script>
<style lang="less" scoped>
.b-file-item {
    &.default {
        @h: 80px;
        .borderBox();
        width: 190px;
        height: @h;
        // line-height: @h;
        // margin: 10px;
        padding: 10px;
        transition: box-shadow .3s;
        border-radius: 5px;
        &:hover {
            box-shadow: 0 12px 24px rgba(7, 17, 27, .3);
            border: none;
        }
        .file-content {
            i {
                font-size: 2em;
            }
            .file-name {
                display: inline-block;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                max-width: 120px;
            }
        }
        .file-info {
            margin-top: 10px;
            > span {
                display: inline-block;
                height: 1.2em;
                line-height: 1.2em;
                font-size: 12px;
            }
        }
    }
}
</style>