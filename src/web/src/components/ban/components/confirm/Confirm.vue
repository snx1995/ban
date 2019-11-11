<template>
    <div class="confirm" :class="type">
        <div class="overlay" @click="handleCancel"></div>
        <transition tag="div" name="fade">
            <div class="content" v-show="showContent">
                <div class="title">{{title}}</div>
                <div class="body">
                    <i class="confirm-icon icon-question-circle"></i>
                    <p>{{prompt}}</p>
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
            default: 'warning' // warning/danger/info/success
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
            this.showContent = false;
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
        background-color: rgba(0, 0, 0, 0.3);
    }
    .content {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #fff;
        min-width: 400px;
        padding: 10px;
        border-radius: 10px;
        .title {
            width: 100%;
            padding: 10px;
            font-weight: bold;
            font-size: 18px;
            
        }
        .body {
            padding: 10px 10px 20px;
            display: flex;
            .confirm-icon {
                padding-right: 10px;
                color: @warning;
                font-size: 24px;
                vertical-align: sub;
            }
            p {
                flex-grow: 1;
            }
        }
        .footer {
            text-align: right;
        }
    }
}
</style>