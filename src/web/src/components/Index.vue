<template>
    <div class="index">
        <h1>{{title}}</h1>
        <BButton type="primary" :loading="loading">
            <template v-slot:icon>
                <i class="icon-home"></i>
            </template>
            首页
            <template v-slot:icon-post>
                <i class="icon-github"></i>
            </template>
        </BButton>
        <BButton :loading="loading">默认按钮</BButton>
        <BButton type="danger" :loading="loading">危险</BButton>
        <BButton type="success" :loading="loading">成功</BButton>
        <BButton type="info" :loading="loading">提示</BButton>
        <BButton type="warning" :loading="loading">警告</BButton>
        <br>
        <br>
        <BSwitch v-model="switchValue[0]" trueValue="success" falseValue="failed" size="sm"/>
        <br>
        <br>
        <BSwitch v-model="switchValue[4]" trueValue="success" falseValue="failed" size="sm"/>
        <br>
        <br>
        <BSwitch v-model="switchValue[1]" trueValue="success" falseValue="failed" size="md"/>
        <br>
        <br>
        <BSwitch v-model="switchValue[2]" trueValue="success" falseValue="failed" size="lg"/>
    </div>
</template>
<script>
export default {
    data() {
        return {
            title: 'It works!',
            loading: false,
            switchValue: []
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