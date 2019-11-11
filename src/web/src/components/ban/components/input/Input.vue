<template>
    <div class="b-input" :class="theme" :style="{width: width}">
        <div class="wrapper">
            <div class="slotfix prefix" v-if="$scopedSlots.prefix">
                <slot name="prefix"></slot>
            </div>
            <input v-if="type != 'textarea'" :class="{
                    ['b-input-' + type] : true,
                    'no-prefix': !$scopedSlots.prefix,
                    'no-suffix': !$scopedSlots.suffix
                }" 
                :value="value" 
                @input="handleInput"
            >
            <!-- <i class="num-btn icon-plus btn-like" v-if="type == 'number'" @click="inc"></i>
            <i class="num-btn icon-minus btn-like" v-if="type == 'number'" @click="dec"></i> -->
            <div class="slotfix suffix"  v-if="$scopedSlots.suffix">
                <slot name="suffix"></slot>
            </div>
            <textarea v-if="type == 'textarea'" :placeholder="placeholder" :value="value" @input="handleInput">
            </textarea>
        </div>
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
        },
        inc() {
            this.$emit('input', Number.parseInt(this.value) + 1)
        },
        dec() {
            this.$emit('input', this.value - 1)
        }
    },
    mounted() {
        if (this.type == 'number') {
            const val = Number.parseInt(this.value);
            if (Number.isNaN(val)) this.$emit('input', 0);
        }
    }
}
</script>
<style lang="less" scoped>
.b-input {
    @borderRadius: 5px;
    .borderBox();
    display: inline-block;
    position: relative;
    overflow: hidden;
    .wrapper {
        display: flex;
        justify-content: space-between;
    }
    input {
        .borderBox();
        display: inline-block;
        width: 100%;
        height: @inputHeight;
        line-height: @inputHeight;
        outline: none;
        color: @fontColorDark;
        text-indent: 1em;
        border: 1px solid;
        box-shadow: none;
        flex-shrink: 1;
        flex-grow: 1;
        &.no-prefix {
            border-top-left-radius: @borderRadius;
            border-bottom-left-radius: @borderRadius;
        }
        &.no-suffix {
            border-top-right-radius: @borderRadius;
            border-bottom-right-radius: @borderRadius;
        }
    }
    textarea {
        .borderBox();
        width: 100%!important;
        min-height: 5em;
        border-radius: 5px;
        outline: none;
        box-shadow: none;
        display: inline-block;
        color: @fontColorDark;
        padding: 5px;
    }
    .slotfix {
        .borderBox();
        display: inline-block;
        padding: 0 10px;
        text-align: center;
        line-height: @inputHeight;
        color: @fontColorLight;
        &.prefix {
            border-radius: 5px 0 0 5px;
        }
        &.suffix {
            border-radius: 0 5px 5px 0;
        }
    }
    .b-input-number {
        text-align: center;
    }
    .num-btn {
        .borderBox();
        color: @fontColorLight;
        display: inline-block;
        height: @inputHeight;
        line-height: @inputHeight;
        width: @inputHeight;
        cursor: pointer;
        position: absolute;
        top: 0;
        border-color: inherit;
        &.icon-plus {
            right: 0;
            border-radius: 0 5px 5px 0;
        }
        &.icon-minus {
            left: 0;
            border-radius: 5px 0 0 5px;
        }
    }
    &.default {
        input {
            border-color: @fontColorDark;
        }
        textarea {
            border-color: @fontColorDark;
        }
        .num-btn {
            background-color: white;
            color: @fontColorDark;
            border: 1px solid @fontColorDark;
        }
        .slotfix {
            border: 1px solid @fontColorDark;
            color: @fontColorDark;
            background-color: white;
        }
    }
    &.primary {
        input {
            border-color: @primary;
        }
        textarea {
            border-color: @primary;
        }
        .num-btn {
            background-color: @primary;
        }
        .slotfix {
            background-color: @primary;
        }
    }
    &.warning {
        input {
            border-color: @warning;
        }
        textarea {
            border-color: @warning;
        }
        .num-btn {
            background-color: @warning;
        }
        .slotfix {
            background-color: @warning;
        }
    }
    &.info {
        input {
            border-color: @info;
        }
        textarea {
            border-color: @info;
        }
        .num-btn {
            background-color: @info;
        }
        .slotfix {
            background-color: @info;
        }
    }
    &.success {
        input {
            border-color: @success;
        }
        textarea {
            border-color: @success;
        }
        .num-btn {
            background-color: @success;
        }
        .slotfix {
            background-color: @success;
        }
    }
    &.ghost {
        input {
            border-color: @ghost;
        }
        textarea {
            border-color: @ghost;
        }
        .num-btn {
            background-color: @ghost;
        }
        .slotfix {
            background-color: @ghost;
        }
    }
    &.danger {
        input {
            border-color: @error;
        }
        textarea {
            border-color: @error;
        }
        .num-btn {
            background-color: @error;
        }
        .slotfix {
            background-color: @error;
        }
    }
}
</style>
