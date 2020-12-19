<template>
    <div class="gladiator" 
        :class="'glad' + gladiator.gladiatorType + ' gladPlayer' + playerId"
        v-bind:style="getGladiatorPosition"
        @click="clickGladiator()"
        @mouseenter="updateHoveredGladiator()"
        @mouseleave="resetHoveredGladiator()">
    </div>
</template>       


<script>
    import Vue from 'vue';
    import { selectedGladiatorMixin } from '../mixins/selectedGladiatorMixin';

    export default Vue.component('gladiator', {
        mixins: [selectedGladiatorMixin],
        props: {
            gladiator: Object,
            playerId: Number
        },
        computed: {
            getGladiatorPosition: function() {
                console.log("getting glad pos");
                let leftPx = this.gladiator.position.x * (100 / 15),
                    topPx = this.gladiator.position.y * (100 / 15);
                return 'top: ' + topPx + '%; left: ' + leftPx + '%;';
            }
        },
        methods: {
            clickGladiator() {
                var sGlad = {
                    gladiator: this.gladiator,
                    source: "Board"
                }
                this.$store.commit('SET_SELECTEDGLADIATOR', sGlad);
                this.$store.dispatch("hightlightTiles", this.gladiator.position);
            }
        }
    });
</script>

<style scoped lang="scss">
   .gladiator {
        transition: 1s;
        position: absolute;
        height: calc(100% / 15);
        width: calc(100% / 15);
        background-size: contain;
        background-position: center;
        background-repeat: no-repeat;
        cursor: pointer;
        
        &.gladTank {
            background-image: url("/assets/images/gladiators/shield.png"); 
        }
        &.gladKnight {
            background-image: url("/assets/images/gladiators/sword.png");
        }
        &.gladArcher {
            background-image: url("/assets/images/gladiators/bow.png"); 
        }
        &.gladPlayer1 {
            filter: invert(29%) sepia(94%) saturate(418%) hue-rotate(142deg) brightness(94%) contrast(88%);
        }
        &.gladPlayer2 {
           filter: invert(27%) sepia(91%) saturate(1837%) hue-rotate(22deg) brightness(99%) contrast(99%);
        }
        &.active {  
            animation: perspect 1s infinite linear 
        }
        &.attacked {
            animation: attacked 0.2s infinite ease-out;
        }
        &.shake {
            animation: shake 1s cubic-bezier(.36,.07,.19,.97) both;
        }
    }
</style>

