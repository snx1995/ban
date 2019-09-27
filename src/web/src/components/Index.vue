<template>
    <div class="index">
        <h1>{{title}}</h1>
        <div class="form-row">
            <BButton theme="primary" :loading="loading" @click="loading = true">
                <template v-slot:icon>
                    <i class="icon-home"></i>
                </template>
                首页
                <template v-slot:icon-post>
                    <i class="icon-github"></i>
                </template>
            </BButton>
            <BButton :loading="loading">默认按钮</BButton>
            <BButton theme="danger" :loading="loading">危险</BButton>
            <BButton theme="success" :loading="loading">成功</BButton>
            <BButton theme="info" :loading="loading">提示</BButton>
            <BButton theme="warning" :loading="loading">警告</BButton>
            <br>
            <br>
            <BButton theme="primary" :loading="loading" disabled>
                <template v-slot:icon>
                    <i class="icon-home"></i>
                </template>
                首页
                <template v-slot:icon-post>
                    <i class="icon-github"></i>
                </template>
            </BButton>
            <BButton :loading="loading" disabled>默认按钮</BButton>
            <BButton theme="danger" :loading="loading" disabled>危险</BButton>
            <BButton theme="success" :loading="loading" disabled>成功</BButton>
            <BButton theme="info" :loading="loading" disabled>提示</BButton>
            <BButton theme="warning" :loading="loading" disabled>警告</BButton>
        </div>
        <div class="form-row">
            <BSwitch v-model="switchValue[4]" trueValue="success" falseValue="failed" size="sm"/>
            <BSwitch v-model="switchValue[1]" trueValue="success" falseValue="failed" size="md"/>
            <BSwitch v-model="switchValue[2]" trueValue="success" falseValue="failed" size="lg"/>
        </div>
        <div class="form-row">
            <BCheckbox v-model="checkbox[0]">测试</BCheckbox>
            <BCheckbox v-model="checkbox[1]" theme="success">测试</BCheckbox>
            <BCheckbox v-model="checkbox[2]" theme="info">测试</BCheckbox>
            <BCheckbox v-model="checkbox[3]" theme="warning">测试</BCheckbox>
            <BCheckbox v-model="checkbox[4]" theme="danger">测试</BCheckbox>
            <BCheckbox v-model="checkbox[5]" theme="ghost">测试</BCheckbox>
        </div>
        <div class="form-row">
            <BRadio name="test" v-model="radio[0]">测试</BRadio>
            <BRadio name="test" v-model="radio[1]" theme="success">测试</BRadio>
            <BRadio name="test" v-model="radio[2]" theme="info">测试</BRadio>
            <BRadio name="test" v-model="radio[3]" theme="warning">测试</BRadio>
            <BRadio name="test" v-model="radio[4]" theme="danger">测试</BRadio>
            <BRadio name="test" v-model="radio[5]" theme="ghost">测试</BRadio>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            title: 'It works!',
            loading: false,
            switchValue: [],
            checkbox: [false, false, false, false, false, false],
            radio: []
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
    .form-row {
        margin: 0 auto;
        width: 800px;
        padding: 20px 0;
        border-top: 1px dashed @ghost;
        &:last-child {
            border-bottom: 1px dashed @ghost;
        }
    }
}
</style>