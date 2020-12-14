Vue.use(Vuex);
 
const initialState = {
  player1: {
    name: "Sascha",
    credits: 100,
    base: 100
  }
};
 
export default new Vuex.Store({
  state: initialState,
  getters: {
    player1: initialState => initialState.player1
  }
});