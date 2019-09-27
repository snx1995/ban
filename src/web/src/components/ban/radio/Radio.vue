<template>
    <label class="b-radio" :class="[theme]">
        <input type="radio" @click.stop :name="name" @change="handleChange">
        <span>
            <i class="icon-radio-checked2"></i>
            <i class="icon-radio-unchecked"></i>
        </span>
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
    name: 'BRadio',
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
        theme: {
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
            const inputEl = this.$el.querySelector('input');
            if (inputEl.checked) this.$emit('input', this.falseValue);
            else his.$emit('input', this.trueValue);
        }
    },
    mounted() {
        const inputEl = this.$el.querySelector('input');
        if (this.value == this.trueValue) inputEl.checked = true;
        else inputEl.checked = false;
    },
    watch: {
        value() {
            console.log(this.value);
        }
    }
}
</script>
<style lang="less" scoped>
.b-radio {
    display: inline-block;
    input {
        display: none;
        &:checked + span {
            .icon-radio-checked2 {
                display: inline-block;
            }
            .icon-radio-unchecked {
                display: none;
            }
        }
        & + span {
            .icon-radio-checked2 {
                display: none;
            }
            .icon-radio-unchecked {
                display: inline-block;
            }
        }
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
