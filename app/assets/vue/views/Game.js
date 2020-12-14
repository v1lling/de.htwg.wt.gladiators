import '/assets/vue/App.js';
import '/assets/vue/components/navbar.js';
import '/assets/vue/components/player-info.js';

const Game = {
    template: `
    <div class="container my-container game">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-lg-2 panel">
                <player-info v-bind:player="$store.getters.player1"/>
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
      //  alert("gotcha");
    }
}

export default Game;