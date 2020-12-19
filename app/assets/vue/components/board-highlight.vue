<template>
    <div class="board-highlight" :style="getHighlightPosition()" :class="getHighlightClass()"></div>
</template>       


<script>
    import Vue from 'vue';
    export default Vue.component('board-highlight', {
        props: {
            coordinates: Object,
            mode: String
        },
        methods: {
            getHighlightClass() {
                return 'tile' + this.mode + ' tilePlayer' + this.$store.state.controller.currentPlayer.id;
            },
            getHighlightPosition: function() {
                let addition = this.mode == "Attack" ? (100/60) : 0,
                    leftPx = this.coordinates.x * (100 / 15) + addition,
                    topPx = this.coordinates.y * (100 / 15) + addition;
                return 'top: ' + topPx + '%; left: ' + leftPx + '%;';
            }
        }
    });
</script>

<style scoped lang="scss">
    @keyframes blinker {
        50% { opacity: 0.2;}
    }
    .board-highlight {
        height: calc(100% / 15);
        width: calc(100% / 15);
        position: absolute;
        background-size: contain;
        background-position: center;
        background-repeat: no-repeat;
        cursor: pointer;
        &.tileAttack {
            animation: blinker 2s linear infinite;
            background-image: url("/assets/images/attack.png"); 
            height: calc(100% / 30);
            width: calc(100% / 30);
            &.tilePlayer1 {
                filter: invert(29%) sepia(94%) saturate(418%) hue-rotate(142deg) brightness(94%) contrast(88%);
            }
            &.tilePlayer2 {
                filter: invert(27%) sepia(91%) saturate(1837%) hue-rotate(22deg) brightness(99%) contrast(99%);
            }
        }
        &.tileMove {
            opacity: 0.2;
            border-radius: 50%;
            background: green;
        }
    }
</style>


