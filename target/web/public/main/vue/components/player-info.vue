<template>
    <div class="playerinfo" :class="getClass">
        <div class="playerinfo-row">
            <div>Name:</div>
            <div id="idPlayer2Name">
                {{ player && player.name || "-" }}
            </div>
        </div>
        <div class="playerinfo-row">
            <div>Base:</div>
            <div id="idPlayer2Health">
                {{ player && player.health || "-" }}
            </div>
        </div>
        <div class="playerinfo-row">
            <div>Credits:</div>
            <div id="idPlayer2Credits">
                {{ player && player.credits || "-" }}
            </div>
        </div> 
    </div>
</template>

<script>
    import Vue from 'vue';
    export default Vue.component('player-info', {
        props: {
            player: Object,
            turn: Boolean
        },
        computed: {
            getClass() {
                if (this.turn) {
                    return 'playerTurn player' + this.player.id;
                }
            }
        }
    });
</script>

<style scoped lang="scss">
    @keyframes pulse {
        0% {transform: scale(1, 1);} 
        50% {transform: scale(1.05, 1.05);}
        100% {transform: scale(1, 1);}
    }
    .playerinfo {
        border: 1px solid black;
        border-radius: 5px;
        width: 100%;
        background-color: ivory;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
        position: relative;
        display: flex;
        flex-direction: column;
        padding: 1rem;
        &.playerTurn {
            border: 5px solid red;
            animation: wiggle 2s linear infinite;
        }
        .playerinfo-row {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        &.playerTurn {
            animation: pulse 1s linear infinite;
            &.player1 {
                border: 4px solid #006b7b;
            }
            &.player2 {
                border: 4px solid #be5701;;
            }
        }
        &:not(:last-child) {
            margin-bottom: 1rem;
        }
    }
</style>
