<template>
    <div class="b-loading">
        <div class="loading-content">
            <i class="icon-spinner"></i>
        </div>
    </div>
</template>
<script>
export default {
    name: 'BLoading'
}
</script>
<style lang="less" scoped>
.b-loading {
    z-index: @topIndex;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    .loading-content {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 100px;
        height: 100px;
        i {
            font-size: 64px;
        }
    }
}
</style>
