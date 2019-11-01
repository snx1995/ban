<template>
    <label class="b-switch" @click.stop="handleChange">
        <input type="text" @click.stop :value="value" :name="name" :class="{'enabled': value == trueValue}">
        <span :class="[size]"></span>
    </label>
</template>
<script>
export default {
    props: {
        name: String,
        value: {
            type: [String, Number, Boolean],
            default: false
        },
        trueValue: {
            type: [String, Number, Boolean],
            default: true
        },
        falseValue: {
            type: [String, Number, Boolean],
            default: false
        },
        size: {
            type: String,
            default: 'sm'
        }
    },
    data() {
        return {
        }
    },
    methods: {
        handleChange() {
            console.log(this.value);
            if (this.value == this.trueValue) this.$emit('input', this.falseValue);
            else this.$emit('input', this.trueValue);
        }
    }
}
</script>
<style lang="less" scoped>
.b-switch {
    .borderBox();
    display: inline-block;
    cursor: pointer;
    input {
        display: none;
        &.enabled + span {
            background-color: @success;
            &.sm::before {
                left: 15px;
            }
            &.md::before {
                left: 20px;
            }
            &.lg::before {
                left: 20px;
            }
        }
    }
    span {
        display: inline-block;
        position: relative;
        background-color: @ghost;
        transition: background-color .3s;
        margin: 5px 0;
        &.sm {
            border-radius: 10px;
            height: 15px;
            width: 35px;
            &.sm::before {
                width: 20px;
                height: 20px;
            }
        }
        &.md {
            border-radius: 10px;
            height: 20px;
            width: 50px;
            &::before {
                width: 30px;
                height: 30px;
            }
        }
        &.lg {
            border-radius: 15px;
            height: 30px;
            width: 60px;
            &::before {
                width: 40px;
                height: 40px;
            }
        }
        &::before {
            content: "";
            display: inline-block;
            position: absolute;
            top: 50%;
            left: 0;
            transform: translateY(-50%);
            filter: brightness(.6);
            border-radius: 50%;
            background-color: inherit;
            box-shadow: 0 0 4px rgba(7, 17, 27, .3);
            transition: left .3s;
        }
    }
}
</style>
