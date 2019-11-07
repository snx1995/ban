<template>
    <div class="confirm" :class="type">
        <div class="overlay" @click="handleCancel"></div>
        <transition tag="div" name="fade">
            <div class="content" v-show="showContent">
                <div class="title"><i class="confirm-icon"></i>{{title}}</div>
                <div class="body">
                    {{prompt}}
                </div>
                <div class="footer">
                    <BButton @click="handleCancel">{{cancelText}}</BButton>
                    <BButton @click="handleConfirm" theme="primary">{{confirmText}}</BButton>
                </div>
            </div>
        </transition>
    </div>
</template>
<script>
export default {
    name: 'BConfirm',
    props: {
        cancelText: {
            type: String,
            default: '取消'
        },
        confirmText: {
            type: String,
            default: '确认'
        },
        title: {
            type: String,
            default: '提示'
        },
        prompt: {
            type: String,
            default: ''
        },
        type: {
            type: String,
            default: 'warningr' // warning/danger/info/success
        },
        onConfirm: {
            type: Function,
            default: () => {}
        },
        onCancel: {
            type: Function,
            default: () => {}
        }
    },
    data() {
        return {
            showContent: false
        }
    },
    methods: {
        handleConfirm() {
            if (typeof this.onConfirm == 'function') this.onConfirm();
        },
        handleCancel() {
            if (typeof this.onCancel == 'function') this.onCancel();
        }
    },
    mounted() {
        this.showContent = true;
    },
}
</script>
<style lang="less" scoped>
.confirm {
    z-index: 99999;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    .overlay {
        width: 100%;
        height: 100%;
        position: absolute;
        top: 0;
        left: 0;
        background-color: rgba(0, 0, 0, 0.2);
    }
    .content {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #fff;
        min-width: 300px;
        .title {
            width: 100%;
        }
        .body {
            padding: 20px;
        }
    }
}
</style>