<template>
    <button class="ban-btn" @click.stop="handleClick">
        <i class="icon-spinner6 i-loading" v-if="loading"></i>
        <slot></slot>
    </button>
</template>
<script>
export default {
    name: 'ban-btn',
    props: {
        loading: {
            type: Boolean,
            default: false
        },
        type: {
            type: String,
            default: 'default',
            validator(value) {
                return '[default][primary][ghost]'.indexOf(`[${value}]`) > 0;
            }
        }
    },
    data() {
        return {

        }
    },
    methods: {
        handleClick() {
            if (!this.loading) this.$emit('click');
        }
    }
}
</script>
<style lang="less" scoped>
button {
    // .borderBox();
    .i-loading {
        display: inline-block;
        animation: rotate 1s linear infinite;
    }
}
</style>