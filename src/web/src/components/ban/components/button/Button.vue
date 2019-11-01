<template>
    <button class="ban-btn" :class="[themes[theme], size, disabled  ? 'disabled' : '']" @click.stop="handleClick">
        <slot name="icon" class="btn-icon"></slot>
        <i class="icon-spinner3 i-loading" v-if="loading"></i>
        <slot></slot>
        <slot name="icon-post" class="btn-icon"></slot>
    </button>
</template>
<script>
export default {
    name: 'BButton',
    props: {
        loading: {
            type: Boolean,
            default: false
        },
        theme: {
            type: String,
            default: 'default'
        },
        size: {
            type: String,
            default: 'md',
            validator(value) {
                return value == 'sm' || value == 'md' || value == 'lg';
            }
        },
        disabled: {
            type: Boolean,
            default: false
        }
    },
    data() {
        return {
            themes: {
                primary: 'primary',
                success: 'success',
                info: 'info',
                warning: 'warning',
                danger: 'danger',
                default: 'default',
                ghost: 'ghost'
            }
        }
    },
    methods: {
        handleClick() {
            if (!this.loading && !this.disabled) this.$emit('click');
        }
    }
}
</script>
<style lang="less" scoped>
button {
    .borderBox();
    display: inline-block;
    border-radius: 6px;
    cursor: pointer;
    outline: none;
    box-shadow: none;
    border: 1px solid;
    color: @fontColorLight;
    &:not(.disabled):hover {
        filter: brightness(.9);
    }
    &:active {
        outline: none;
        box-shadow: none;
        &:not(.disabled) {
            filter: brightness(.8);
        }
    }
    .i-loading::before {
        display: inline-block;
        animation: rotate 1s steps(12) infinite;
    }
    .btn-icon {
        display: inline-block;
    }
    &.sm {
        padding: 8px 9px;
        font-size: 12px;
    }
    &.md {
        padding: 11px 16px;
        font-size: 14px;
    }
    &.lg {
        padding: 13px 24px;
        font-size: 18px;
    }
    &.primary {
        background-color: @primary;
        border-color: @primary;
    }
    &.success {
        background-color: @success;
        border-color: @success;
    }
    &.info {
        background-color: @info;
        border-color: @info;
    }
    &.warning {
        background-color: @warning;
        border-color: @warning;
    }
    &.danger {
        background-color: @error;
        border-color: @error;
    }
    &.default {
        background-color: white;
        border-color: @fontColorDark;
        color: @fontColorDark;
    }
    &.ghost {
        background-color: @ghost;
        border-color: @ghost;
    }
    &.disabled {
        cursor: default;
        background-color: @disabled;
        border-color: @disabled;
        color: @fontColorDisabled;
    }
}
</style>