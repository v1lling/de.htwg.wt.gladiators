<template>
    <div class="playerinfo player2">
        <div class="playerinfo-row">
            <div>Name:</div>
            <div id="idPlayer2Name">
                {{ player.name }}
            </div>
        </div>
        <div class="playerinfo-row">
            <div>Base:</div>
            <div id="idPlayer2Health">
                {{ player.base }}
            </div>
        </div>
        <div class="playerinfo-row">
            <div>Credits:</div>
            <div id="idPlayer2Credits">
                {{ player.credits }}
            </div>
        </div> 
    </div>
</template>

<script>
    import Vue from 'vue';
    export default Vue.component('player-info', {
        props: {
            player: Object
        }
    });
</script>

<style scoped lang="scss">
    .playerinfo, .gladiatorinfo {
        border: 1px solid black;
        border-radius: 5px;
        width: 100%;
        background-color: ivory;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
        position: relative;
        display: flex;
        flex-direction: column;
        .playerinfo-row {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        &.active {
            animation: pulse 1s linear infinite;
            &.player1 {
                border: 2px solid #2525b5;
            }
            &.player2 {
                border: 2px solid #f13737;;
            }
        }
    }
    .playerinfo {
        padding: 1rem;

        &:not(:last-child) {
            margin-bottom: 1rem;
        }
    }

</style>
