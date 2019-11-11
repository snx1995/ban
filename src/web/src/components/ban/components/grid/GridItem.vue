<template>
    <div class="b-grid-item">
        <div class="content" :draggable="draggable">
            <slot></slot>
        </div>
    </div>
</template>
<script>
export default {
    name: 'BGridItem',
    props: {
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
.b-grid-item {
    height: 100%;
    flex-shrink: 1;
    flex-grow: 1;
    border: 1px solid #000;
    .content {
        width: 100%;
        height: 100%;
    }
}
</style>
