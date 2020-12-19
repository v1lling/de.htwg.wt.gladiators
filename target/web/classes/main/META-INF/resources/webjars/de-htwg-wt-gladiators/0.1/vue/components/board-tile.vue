<template>
    <div class="board-tile" :class="getTileClass()" @click="handleClick()">{{player}}</div>
</template>       


<script>
    import Vue from 'vue';
    export default Vue.component('board-tile', {
        props: {
            clickFn: Function,
            coordinates: Object,
            tileType: String,
            playerId: Boolean
        },
        methods: {
            handleClick() {
                this.$emit('tileClicked', this.coordinates);
            },
            getTileClass() {
                if (!this.playerId) {
                    return 'tile' + this.tileType;
                } else {
                    return 'tile' + this.tileType + this.playerId;
                }
            }
        }
    });
</script>

<style scoped lang="scss">
    .board-tile {
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        &.tileSand {
            background-image: url("/assets/images/board/sand.png");
        }
        &.tileBase1 {
            background-image: url("/assets/images/board/colloseum.png");
        }
        &.tileBase2 {
            background-image: url("/assets/images/board/temple.png");
        }
        &.tilePalm {
            background-image: url("/assets/images/board/palm.png");
        }
        &.tileMine {
            background-image:url("/assets/images/board/gold.png");
        }
        &:hover {
            box-shadow: inset 0px 0px 0px 36px rgba(255, 255, 255, .5);
        }
        &.move-range {
            box-shadow: inset 0px 0px 0px 36px rgba(8, 206, 50, 0.2);
        }
        &.attack-range {
            animation: blinker 1s linear infinite;
        }
    }
</style>


