<template>
    <div class="ban-message" :class="[type]" @mouseenter="handleMouseEnter" @mouseleave="handleMouseLeave" @click="handleClick">
        <span>{{message}}</span>
    </div>
</template>
<script>
export default {
    name: 'BMessage',
    props: {
        option: {
            type: Object,
            default: {}
        },
        index: Number
    },
    data() {
        return {
            id: -1,
            autoCloseTimer: undefined,
            type: 'success',
            message: '',
            closeable: true,
            clickCallback() {},
            closeCallback() {},
            autoClose: true,
            autoCloseDelay: 5000
        }
    },
    methods: {
        handleClick() {
            if (typeof this.clickCallback == 'function') this.clickCallback();
        },
        handleMouseLeave() {
            if (this.autoCloseTimer) clearTimeout(this.autoCloseTimer);
            this.autoCloseTimer = setTimeout(() => this.handleClose(), this.autoCloseDelay);
        },
        handleMouseEnter() { 
            if (this.autoCloseTimer) clearTimeout(this.autoCloseTimer);
        },
        handleClose() {
            this.$emit('close', this.id);
            this.closeCallback();
        }
    },
    mounted() {
        const option = this.option;
        if (option.id) this.id = option.id;
        if (option.type) this.type = option.type;
        if (option.message) this.message = option.message;
        if (option.closeable) this.closeable = option.closeable;
        if (option.clickCallback) this.clickCallback = option.clickCallback;
        if (option.closeCallback) this.closeCallback = option.closeCallback;
        if (option.autoClose) this.autoClose = option.autoClose;
        if (option.autoCloseDelay) this.autoCloseDelay = option.autoCloseDelay;
        this.autoCloseTimer = setTimeout(() => this.handleClose(), this.autoCloseDelay);
    },
    watch: {
        autoCloseTimer() {

        }
    }
}
</script>
<style lang="less" scoped>
.ban-message {
    .borderBox();
    position: relative;
    width: 100%;
    padding: 20px;
    border-left: 10px solid;
    border-radius: 10px;
    background-color: #fff;
    margin-top: 10px;
    box-shadow: 0 12px 24px rgba(7, 17, 27, .2);
    &.success {
        border-color: @success;
    }
    &.warning {
        border-color: @warning;
    }
    &.error {
        border-color: @error;
    }
    &.info {
        border-color: @info;
    }
}
</style>