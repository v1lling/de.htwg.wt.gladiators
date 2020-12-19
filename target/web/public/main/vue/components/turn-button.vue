<template>
    <button :disabled="buttonDisabled" type="button" class="btn btn-rounded turnbutton" @click="endTurn()"> 
        {{ buttonText }}
    </button>
</template>

<script>
    import Vue from 'vue';
    export default Vue.component('turn-button', {
        computed: {
            buttonText() {
                if (this.$store.state.controller.playerOne 
                    && this.$store.state.controller.playerTwo) {

                    if (this.$store.state.myPlayerId) {
                        if(this.$store.state.controller.currentPlayer 
                            && this.$store.state.controller.currentPlayer.id == this.$store.state.myPlayerId ) {
                            return "End Turn";
                        } else {
                            return "Wait";
                        }
                    } else {
                        return "Spectating";
                    }
                } else {
                    return "Lobby";
                }
            },
            buttonDisabled() {
                if (this.$store.state.myPlayerId
                    && this.$store.state.controller.currentPlayer
                    && this.$store.state.controller.currentPlayer.id == this.$store.state.myPlayerId ) {
                    return false;
                } else {
                    return true;
                }
            }
        },
        methods: {
            endTurn() {
                this.$store.dispatch("endTurn");
            }
        }
    });
</script>

<style scoped lang="scss">
    .turnbutton.btn {
        background: #d3b0a8;
        background-position: center;
        background-size: auto;
        background-color: #d89755;
        background-image: url("/assets/images/shield_transparent.png"); 
        animation: animatedBackground 30s linear infinite;
        &:disabled {
            opacity: 1;
            cursor: default;
        }
        &.button-turn {
            background: #28a745;
        }
        &.button-spec {
            background-size: auto;
        }
    }
</style>
