<template>
    <div class="b-radio-group">
        <slot></slot>
    </div>    
</template>
<script>
export default {
    name: 'BRadioGroup',
    data() {
        return {

        }
    },
    mounted() {
        console.log(this);
    }
}
</script>
<style lang="less" scoped>
.b-radio-group {
    .borderBox();
}
</style>
