<template>
    <div class="b-file-item" :class="[theme, type]">
        <div class="content">
            <div class="file-content">
                <i :class="iconClass" class="file-icon"></i>
                <span class="file-name" :title="file.name">{{file.name}}</span>
                <i class="icon-cancel-circle file-remove" @click="$emit('remove')"></i>
            </div>
            <div class="file-info">
                <span class="file-size">{{fileSize}}</span>
                <span class="file-date">{{new Date(file.lastModified).format('yyyy-MM-dd hh-mm')}}</span>
            </div>
        </div>
    </div>
</template>
<script>
const fileSizeUnit = 'BKMG';
export default {
    name: 'BFileItem',
    props: {
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
            return size.toFixed(2) + 'G';
        }
    }
}
</script>
<style lang="less" scoped>
.b-file-item {
    @h: 80px;
    display: flex;
    align-items: center;
    background-color: white;
    .file-content {
        display: flex;
        justify-content: space-between;
        align-items: flex-end;
        .file-icon {
            font-size: 2em;
        }
        .file-name {
            cursor: default;
            display: inline-block;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            margin-left: 10px;
        }
        .file-remove {
            cursor: pointer;
            opacity: 0;
            transition: opacity .3s;
        }
    }
    .file-info {
        margin-top: 10px;
        > span {
            display: inline-block;
            font-size: 10px;
            color: white;
        }
        .file-size {
            background-color: @info;
            padding: 2px 4px;
            border-radius: 5px;
        }
        .file-date {
            margin-left: 5px;
            background-color: @red;
            padding: 2px 4px;
            border-radius: 5px;
        }
    }
    &.card {
        .borderBox();
        width: 180px;
        height: @h;
        padding: 10px;
        transition: box-shadow .3s;
        border-radius: 5px;
        .content {
            width: 100%;
        }
        .file-content {
            .file-name {
                max-width: 110px;
            }
        }
        &:hover {
            box-shadow: 0 6px 12px rgba(7, 17, 27, .3);
            border: none;
            .file-remove {
                opacity: 1;
            }
        }
    }
    &.list {
        width: 100%;
        height: @h;
        padding-right: 20px;
        border-bottom: 1px dashed @fontColorGrey;
        transition: filter .3s;
        .content {
            .borderBox();
            width: 100%;
            .file-content {
                display: flex;
                justify-content: space-between;
                flex-grow: 1;
                .file-name {
                    flex-grow: 1;
                }
            }
        }
        &:hover {
            filter: brightness(.9);
            .file-remove {
                opacity: 1;
            }
        }
    }
    .icon-drive {
        color: @blue;
    }
    .icon-file-zip {
        color: @orange;
    }
    .icon-file-picture {
        color: @green;
    }
    .icon-file-video {
        color: @gblue;
    }
    .icon-file-music {
        color: @yellow;
    }
    .icon-file-empty {
        color: @dark;
    }
}
</style>