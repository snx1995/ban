<template>
    <div>
        <transition name="fade" tag="div">
            <div class="b-loading" v-show="loading">
                <div class="loading-content">
                    <i class="icon-spinner2"></i>
                </div>
            </div>
        </transition>
    </div>
</template>
<script>
export default {
    name: "BLoading",
    data() {
        return {
            loading: false
        }
    }
};
</script>
<style lang="less" scoped>
.b-loading {
    z-index: @topIndex;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(255, 255, 255, 0.8);
    .loading-content {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        i {
            display: inline-block;
            font-size: 48px;
            color: @fontColorDarkGrey;
            animation: rotate 1s linear infinite;
        }
        span {
            display: block;
            width: 100%;
            text-align: center;
            color: @primary;
        }
    }
}
</style>
