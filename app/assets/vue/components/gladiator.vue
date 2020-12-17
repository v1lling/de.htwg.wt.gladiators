<template>
    <div class="gladiator" :class="'glad' + gladiator.gladiatorType + ' gladPlayer' + gladiator.playerId"
        v-bind:style="getGladiatorPosition"
        @click="clickGladiator()"
        @mouseenter="updateHoveredGladiator()">
    </div>
</template>       


<script>
    import Vue from 'vue';
    import { selectedGladiatorMixin } from '../mixins/selectedGladiatorMixin';

    export default Vue.component('gladiator', {
        mixins: [selectedGladiatorMixin],
        props: {
            gladiator: Object,
            playerId: Boolean
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
            filter: invert(13%) sepia(95%) saturate(3384%) hue-rotate(240deg) brightness(91%) contrast(88%);
        }
        &.gladPlayer2 {
            filter: invert(47%) sepia(32%) saturate(4586%) hue-rotate(340deg) brightness(81%) contrast(88%);
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

