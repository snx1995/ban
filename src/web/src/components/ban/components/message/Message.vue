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
        }
    },
    data() {
        return {
            autoCloseTimer: undefined,
            id: new Date().getTime(),
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
            this.autoCloseTimer = setTimeout(() => {
                this.$emit('close', this.id)
                if (typeof this.closeCallback == 'function') this.closeCallback();
            }, this.autoCloseDelay);
        },
        handleMouseEnter() { 
            if (this.autoCloseTimer) clearTimeout(this.autoCloseTimer);
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

        this.autoCloseTimer = setTimeout(() => {
            this.$emit('close', this.id);
            this.closeCallback();
        }, this.autoCloseDelay);
    }
}
</script>
<style lang="less" scoped>
.ban-message {
    position: relative;
    width: 100%;
    padding: 20px;
    border-left: 10px;
    border-radius: 10px;
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