import '/assets/vue/App.js';
import '/assets/vue/components/navbar.js';
import '/assets/vue/components/player-info.js';

const Game = {
    template: `
    <div class="container my-container game">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-lg-2 panel">
                <player-info v-bind:player="player1"/>
                <player-info v-bind:player="player2"/>
            </div>
            <div id="idBoard" class="col-xs-12 col-sm-12 col-lg-8 board">
            </div>
            <div class="col-xs-12 col-sm-12 col-lg-2 panel">
            </div>
        </div>
    </div>
    `,   
    data() {
        return {
            test: 'Test'
        }
    },
    mounted() {
        this.$store.dispatch("getJson");
    },
    computed: {
        player1() {
            return this.$store.state.controller.playerOne
        },
        player2() {
            return this.$store.state.controller.playerTwo
        }
    }
}

export default Game;