<template>
    <button class="ban-btn">
        <i class="icon-spinner6"></i>
        <slot></slot>
    </button>
</template>
<script>
export default {
    name: 'ban-btn',
    props: ['loading'],
    data() {
        return {

        }
    }
}
</script>
<style lang="less" scoped>
button {
    .borderBox();
    
}
</style>