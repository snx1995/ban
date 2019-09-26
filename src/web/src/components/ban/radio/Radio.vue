<template>
    <label class="b-radio" @click.stop="handleChange" :class="[type]">
        <input type="radio" @click.stop :name="name">
        <!-- <span> -->
            <i :class="[value == trueValue ? 'icon-radio-checked2' : 'icon-radio-unchecked']"></i>
        <!-- </span> -->
        <span class="b-radio-title">
            <slot></slot>
        </span>
    </label>
</template>
<script>
/**
 * style: [primary, ghost, info, warning, danger, success]
 */
export default {
    name: 'b-radio',
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
.b-radio {
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
    .b-radio-title {
        color: @fontColorDark;
    }
}
</style>
