<template>
    <div class="b-form-item">
        <label>
            {{label}}
        </label>
        <span>
            <slot></slot>
        </span>
    </div>
</template>
<script>
export default {
    name: 'BFormItem',
    props: {

    },
    data() {
        return {

        }
    }
}
</script>
<style lang="less" scoped>

</style>
