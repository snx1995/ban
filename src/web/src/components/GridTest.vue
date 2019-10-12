<template>
    <div class="grid-test">
        <BGrid>
            <BGridRow>
                <BGridItem draggable>1</BGridItem>
                <BGridItem draggable>2</BGridItem>
                <BGridItem draggable>3</BGridItem>
            </BGridRow>
            <BGridRow>
                <BGridItem draggable>4</BGridItem>
                <BGridItem draggable>5</BGridItem>
                <BGridItem draggable>6</BGridItem>
                <BGridItem draggable>7</BGridItem>
                <BGridItem draggable>8</BGridItem>
            </BGridRow>
            <BGridRow>
                <BGridItem draggable>9</BGridItem>
                <BGridItem draggable>10</BGridItem>
            </BGridRow>
            <BGridRow>
                <BGridItem draggable>11</BGridItem>
            </BGridRow>
        </BGrid>
    </div>
</template>
<script>
export default {
    name: 'GridTest',
    props: {},
    data() {
        return {

        }
    }
}
</script>
<style lang="less" scoped>

</style>
