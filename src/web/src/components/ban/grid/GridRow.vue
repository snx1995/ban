<template>
    <div class="b-grid-row" :style="{height}" :draggable="draggable">
        <slot></slot>
    </div>
</template>
<script>
export default {
    name: 'BGridRow',
    props: {
        height: {
            type: String,
            default: '60px'
        },
        draggable: {
            type: Boolean,
            default: false
        }
    },
    data() {
        return {

        }
    }
}
</script>
<style lang="less" scoped>
    .b-grid-row {
        width: 100%;
        display: flex;
        justify-content: space-between;
    }
</style>
