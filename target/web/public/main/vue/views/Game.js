import '/assets/vue/App.js';
import '/assets/vue/components/nav-bar.js';
import '/assets/vue/components/player-info.js';
import '/assets/vue/components/player-input.js';
import '/assets/vue/components/turn-button.js';
import '/assets/vue/components/shop-item.js';
import '/assets/vue/components/gladiator-info.js';
import '/assets/vue/components/board-tile.js';
import '/assets/vue/components/gladiator.js';
import '/assets/vue/components/board-highlight.js';

const Game = {
    template: `
    <div class="container my-container game">
        
        <player-input :playerId="openPlayerSlot"></player-input>
        
        <div class="row">

            <div class="col-xs-12 col-sm-12 col-lg-2 panel">
                <player-info v-bind:player="player2" :turn="turnPlayer == 2"/>
                <turn-button/>
                <player-info v-bind:player="player1" :turn="turnPlayer == 1"/>
            </div>

            <div class="col-xs-12 col-sm-12 col-lg-8">
                <div class="board-tiles">
                    <template v-for="(tileRow, y) in boardTiles">
                        <board-tile v-for="(tile, x) in tileRow" v-bind:tileType="tile.tileType"
                            v-bind:playerId="tile.tileType==='Base' ? (y==0 ? 1 : 2) : null"
                            v-bind:coordinates="{x, y}"
                            @tileClicked="clickTile"/>
                    </template>

                    <board-highlight mode="Attack" v-for="highlight in highlightedAttackTiles" :coordinates="highlight"/>
                    <board-highlight mode="Move" v-for="highlight in highlightedMoveTiles" :coordinates="highlight"/>

                    <gladiator v-for="glad in gladiatorsPlayerOne" v-bind:gladiator="glad" playerId="1"/>
                    <gladiator v-for="glad in gladiatorsPlayerTwo" v-bind:gladiator="glad" playerId="2"/>
                </div>   
            </div>

            <div class="col-xs-12 col-sm-12 col-lg-2 panel">
                <div class="panel-gladiator">
                    <gladiator-info v-bind:gladiator="hoveredGladiator"/>
                </div>

                <div class="panel-shop" >
                    <shop-item v-for="(gladiator, index) in shopGladiators" v-bind:gladiator="gladiator" :shopIndex="index + 1"/>
                </div>
            </div>

        </div>
    </div>
    `,   
    data: {
        
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
        },
        shopGladiators() {
            return this.$store.state.controller.shop ? this.$store.state.controller.shop.stock : []
        },
        hoveredGladiator() {
            return this.$store.state.myHoveredGladiator
        },
        selectedGladiator() {
            return this.$store.state.mySelectedGladiator
        },
        boardTiles() {
            return this.$store.state.controller.board.tiles
        },
        gladiatorsPlayerOne() {
            return this.$store.state.controller.playerOne ? this.$store.state.controller.playerOne.gladiators : []
        },
        gladiatorsPlayerTwo() {
            return this.$store.state.controller.playerTwo ? this.$store.state.controller.playerTwo.gladiators : []
        },
        openPlayerSlot() {
            if (this.$store.state.controller.gameState == "NamingPlayerOne") {
                return 1;
            } else if (this.$store.state.controller.gameState == "NamingPlayerTwo") {
                return 2;
            } else {    
                return null;
            }
        },
        highlightedAttackTiles() {
            return this.$store.state.myHighlightedTiles ? this.$store.state.myHighlightedTiles.tilesAttack : []
        },
        highlightedMoveTiles() {
            return this.$store.state.myHighlightedTiles ? this.$store.state.myHighlightedTiles.tilesMove : []
        },
        turnPlayer() {
            return this.$store.state.controller.currentPlayer ? this.$store.state.controller.currentPlayer.id : null;
        }
    },
    methods: {
        clickTile: function(coordinates) {
            if (this.selectedGladiator.source == "Shop") {
                this.$store.dispatch("buyGladiator", coordinates);
            } else if (this.selectedGladiator.source == "Board") {
                this.$store.dispatch("moveGladiator", coordinates);
            } else {
                console.log("Something went wrong here");
            }
        }
    }
}

export default Game;