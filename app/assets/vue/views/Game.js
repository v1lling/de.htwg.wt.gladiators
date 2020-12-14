import '/assets/vue/components/first-component.js';
import '/assets/vue/App.js';
import '/assets/vue/components/navbar.js';
const Game = {
    template: `
    <div>
        <FirstComponent/>
        <div>
            This is the game
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