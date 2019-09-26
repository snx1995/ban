<template>
    <div class="index">
        <h1>{{title}}</h1>
        <div class="form-row">
            <BButton type="primary" :loading="loading" @click="loading = true">
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
            <BButton type="primary" :loading="loading" disabled>
                <template v-slot:icon>
                    <i class="icon-home"></i>
                </template>
                首页
                <template v-slot:icon-post>
                    <i class="icon-github"></i>
                </template>
            </BButton>
            <BButton :loading="loading" disabled>默认按钮</BButton>
            <BButton type="danger" :loading="loading" disabled>危险</BButton>
            <BButton type="success" :loading="loading" disabled>成功</BButton>
            <BButton type="info" :loading="loading" disabled>提示</BButton>
            <BButton type="warning" :loading="loading" disabled>警告</BButton>
        </div>
        <div class="form-row">
            <BSwitch v-model="switchValue[4]" trueValue="success" falseValue="failed" size="sm"/>
            <BSwitch v-model="switchValue[1]" trueValue="success" falseValue="failed" size="md"/>
            <BSwitch v-model="switchValue[2]" trueValue="success" falseValue="failed" size="lg"/>
        </div>
        <div class="form-row">
            <BCheckbox v-model="checkbox[0]">测试</BCheckbox>
            <BCheckbox v-model="checkbox[1]" type="success">测试</BCheckbox>
            <BCheckbox v-model="checkbox[2]" type="info">测试</BCheckbox>
            <BCheckbox v-model="checkbox[3]" type="warning">测试</BCheckbox>
            <BCheckbox v-model="checkbox[4]" type="danger">测试</BCheckbox>
            <BCheckbox v-model="checkbox[5]" type="ghost">测试</BCheckbox>
        </div>
        <div class="form-row">
            <BRadio v-model="radio[0]">测试</BRadio>
            <BRadio v-model="radio[1]" type="success">测试</BRadio>
            <BRadio v-model="radio[2]" type="info">测试</BRadio>
            <BRadio v-model="radio[3]" type="warning">测试</BRadio>
            <BRadio v-model="radio[4]" type="danger">测试</BRadio>
            <BRadio v-model="radio[5]" type="ghost">测试</BRadio>
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
            checkbox: [],
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