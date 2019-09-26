<template>
    <div class="index">
        <h1>{{title}}</h1>
        <BButton type="primary" :loading="loading">
            <template v-slot:icon>
                <i class="icon-home"></i>
            </template>
            首页
        </BButton>
        <BButton :loading="loading">默认</BButton>
        <BButton type="danger" :loading="loading">危险</BButton>
        <BButton type="success" :loading="loading">成功</BButton>
        <BButton type="info" :loading="loading">提示</BButton>
        <BButton type="warning" :loading="loading">警告</BButton>
        <br>
        <br>
        <BButton type="primary" @click="handleClick" size="sm" :loading="loading">
            <template v-slot:icon>
                <i class="icon-home"></i>
            </template>
            Test
        </BButton>
        <BButton type="primary" :loading="loading">Test</BButton>
        <BButton type="primary" size="lg" :loading="loading">Test</BButton>
        <br>
        <br>
        <BButton size="sm" :loading="loading">Test</BButton>
        <BButton :loading="loading">Test</BButton>
        <BButton size="lg" :loading="loading">Test</BButton>
        <br>
        <br>
        <BButton type="danger" size="sm" :loading="loading">Test</BButton>
        <BButton type="danger" :loading="loading">Test</BButton>
        <BButton type="danger" size="lg" :loading="loading">Test</BButton>
        <br>
        <br>
        <BButton type="success" size="sm" :loading="loading">Test</BButton>
        <BButton type="success" :loading="loading">Test</BButton>
        <BButton type="success" size="lg" :loading="loading">Test</BButton>
        <br>
        <br>
        <BButton type="info" size="sm" :loading="loading">Test</BButton>
        <BButton type="info" :loading="loading">Test</BButton>
        <BButton type="info" size="lg" :loading="loading">Test</BButton>
        <br>
        <br>
        <BButton type="warning" size="sm" :loading="loading">Test</BButton>
        <BButton type="warning" :loading="loading">Test</BButton>
        <BButton type="warning" size="lg" :loading="loading">Test</BButton>
    </div>
</template>
<script>
export default {
    data() {
        return {
            title: 'It works!',
            loading: false
        }
    },
    methods: {
        handleClick() {
            this.loading = !this.loading;
        }
    }
}
</script>
<style lang="less" scoped>
.index {
    .borderBox();
}
</style>