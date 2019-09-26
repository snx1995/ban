<template>
    <label class="b-checkbox" @click.stop="handleChange" :class="[type]">
        <input type="checkbox" @click.stop :name="name">
        <span>
            <i :class="[value == trueValue ? 'icon-checkbox-checked' : 'icon-checkbox-unchecked']"></i>
        </span>
        <span class="b-checkbox-title">
            <slot></slot>
        </span>
    </label>
</template>
<script>
/**
 * style: [primary, ghost, info, warning, danger, success]
 */
export default {
    name: 'b-checkbox',
    props: {
        value: {
            type: [String, Number, Boolean],
            default: false
        },
        name: String,
        trueValue: {
            type: [String, Number, Boolean],
            default: true
        },
        falseValue: {
            type: [String, Number, Boolean],
            default: false
        },
        type: {
            type: String,
            default: 'primary'
        }
    },
    data() {
        return {

        }
    },
    methods: {
        handleChange() {
            if (this.value == this.trueValue) this.$emit('input', this.falseValue);
            else this.$emit('input', this.trueValue);
        }
    }
}
</script>
<style lang="less" scoped>
.b-checkbox {
    display: inline-block;
    input {
        display: none;
    }
    &.primary {
        color: @primary;
    }
    &.success {
        color: @success;
    }
    &.info {
        color: @info;
    }
    &.danger {
        color: @error;
    }
    &.warning {
        color: @warning;
    }
    &.ghost {
        color: @ghost;
    }
    .b-checkbox-title {
        color: @fontColorDark;
    }
}
</style>
