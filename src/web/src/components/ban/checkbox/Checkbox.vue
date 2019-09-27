<template>
    <label class="b-checkbox" @click.stop="handleChange" :class="[theme]">
        <input type="checkbox" @click.stop :name="name">
        <span>
            <i class="icon-checkbox-checked"></i>
            <i class="icon-checkbox-unchecked"></i>
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
    name: 'BCheckbox',
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
            if (this.value == this.trueValue) this.$emit('input', this.falseValue);
            else this.$emit('input', this.trueValue);
        }
    },
    mounted() {
        const checkboxEl = this.$el.querySelector('input');
        if (this.value == this.trueValue) checkboxEl.checked = true;
        else checkboxEl.checked = false;
    },
    watch: {
        value() {
            console.log(this.value);
        }
    }
}
</script>
<style lang="less" scoped>
.b-checkbox {
    display: inline-block;
    input {
        display: none;
        &:checked + span {
            .icon-checkbox-checked {
                display: inline-block;
            }
            .icon-checkbox-unchecked {
                display: none;
            }
        }
        & + span {
            .icon-checkbox-checked {
                display: none;
            }
            .icon-checkbox-unchecked {
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
    .b-checkbox-title {
        color: @fontColorDark;
    }
}
</style>
