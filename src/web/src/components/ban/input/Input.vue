<template>
    <div class="b-input" :class="theme" :style="{width: width}">
        <input :type="type" v-if="type != 'textarea'" :class="['b-' + type]" :value="value" @input="handleInput">
        <textarea v-if="type == 'textarea'" :placeholder="placeholder" :value="value" @input="handleInput">
        </textarea>
    </div>
</template>
<script>
export default {
    name: 'BInput',
    props: {
        value: {
            type: [String, Number, Boolean],
            default: ''
        },
        type: {
            type: String,
            default: 'text'
        },
        placeholder: {
            type: String,
            default: ''
        },
        theme: {
            type: String,
            default: 'default'
        },
        width: {
            type: String,
            default: '240px'
        }
    },
    data() {
        return {

        }
    },
    methods: {
        handleInput(event) {
            this.$emit('input', event.target.value);
        }
    }
}
</script>
<style lang="less" scoped>
.b-input {
    .borderBox();
    display: inline-block;
    input {
        .borderBox();
        display: inline-block;
        width: 100%;
        height: @inputHeight;
        line-height: @inputHeight;
        outline: none;
        color: @fontColorDark;
        text-indent: 1em;
        border-radius: 5px;
        box-shadow: none;
        border: 1px solid @init;
    }
    &.default input:hover, &.default input:focus {
        border-color: @fontColorDark;
    }
    &.primary input:hover, &.primary input:focus {
        border-color: @primary;
    }
    &.warning input:hover, &.warning input:focus {
        border-color: @warning;
    }
    &.info input:hover, &.info input:focus {
        border-color: @info;
    }
    &.success input:hover, &.default input:focus {
        border-color: @success;
    }
    &.ghost input:hover, &.ghost input:focus {
        border-color: @ghost;
    }
    &.danger input:hover, &.danger input:focus {
        border-color: @error;
    }
    textarea {
        .borderBox();
        width: 100%!important;
        min-height: 5em;
        border-radius: 5px;
        outline: none;
        box-shadow: none;
        border: 1px solid @init;
        display: inline-block;
        color: @fontColorDark;
        padding: 5px;
    }
    &.default textarea:hover, &.default textarea:focus {
        border-color: @fontColorDark;
    }
    &.primary textarea:hover, &.primary textarea:focus {
        border-color: @primary;
    }
    &.warning textarea:hover, &.warning textarea:focus {
        border-color: @warning;
    }
    &.info textarea:hover, &.info textarea:focus {
        border-color: @info;
    }
    &.success textarea:hover, &.default textarea:focus {
        border-color: @fontColorDark;
    }
    &.ghost textarea:hover, &.ghost textarea:focus {
        border-color: @ghost;
    }
    &.danger textarea:hover, &.danger textarea:focus {
        border-color: @error;
    }
}
</style>
