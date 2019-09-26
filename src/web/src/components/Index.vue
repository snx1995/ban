<template>
    <div class="index">
        <h1><i class="icon-spinner6"></i>{{title}}</h1>
        <BButton :loading="true">Test</BButton>
    </div>
</template>
<script>
export default {
    data() {
        return {
            title: 'It works!'
        }
    }    
}
</script>
<style lang="less" scoped>
.index {
    .borderBox();
    i {
        display: inline-block;
        animation: rotate 1s linear infinite;
    }
}
</style>