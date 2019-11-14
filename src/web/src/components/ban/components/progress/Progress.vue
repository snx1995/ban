<template>
    <div class="b-progress">
        <div class="top-slot" v-if="$scopedSlots.top">1</div>
        <div class="b-progress-wrapper">
            <div class="prefix-slot" v-if="$scopedSlots.prefix">2</div>
            <div class="b-progress-bar">
                <div class="inner" :style="{width: percent + '%'}">
                    {{percent + '%'}}
                </div>
            </div>
            <div class="suffix-slot" v-if="$scopedSlots.suffix"></div>
        </div>
        <div class="bottom-slot" v-if="$scopedSlots.bottom"></div>
    </div>
</template>
<script>
export default {
    name: 'BProgress',
    props: {
        value: {
            type: Number,
            default: 0
        },
        max: {
            type: Number,
            default: 0
        }
    },
    data() {
        return {

        }
    },
    computed: {
        percent() {
            console.log(this.value, this.max);
            const per = this.value / this.max;
            return Math.round(per.toFixed(2));
        }
    }
}
</script>
<style lang="less" scoped>
.b-progress {
    @pbHeight: 36px;
    .borderBox();
    width: 100%;
    display: flex;
    flex-direction: column;
    .b-progress-wrapper {
        width: 100%;
        display: flex;
        .prefix-slot, .suffix-slot {
            flex-shrink: 0;
            flex-grow: 0;
            height: 100%;
        }
        .b-progress-bar {
            height: @pbHeight;
            line-height: @pbHeight;
            flex-shrink: 1;
            flex-grow: 1;
            .inner {
                background-color: @info;
                text-align: right;
            }
        }
    }
}
</style>