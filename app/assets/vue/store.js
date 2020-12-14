Vue.use(Vuex);
 
const initialState = {
  controller: {},
  event: ""
};

const store = new Vuex.Store({
  state: initialState,
  actions: {
    getJson({commit}) {
      $.ajax({
        method: "GET",
        url: "/json",
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
           commit('SET_CONTROLLER', response[0])
        },
        error: function(oResponse) {
            console.log("Something went wrong"); 
        }
    });
    }
  },
  mutations: {
    SET_CONTROLLER(state, controller) {
      state.controller = controller
    },
    SET_EVENT(state, event) {
      state.event = event
    }
  },
  getters: {
    player1: initialState => initialState.player1
  },
  mounted() {
  }
});

var websocket = new WebSocket("ws://localhost:9000/websocket");

websocket.onopen = function(event) {
  console.log("Trying to connect to Server");
}
websocket.onclose = function () {
  console.log('Connection Closed!');
};
websocket.onerror = function (error) {
  console.log('Error Occured: ' + error);
};
websocket.onmessage = function (e) {
  let response = JSON.parse(e.data);

  store.commit('SET_CONTROLLER', response[0]);
  store.commit('SET_EVENT', response[1]);
}

export default store;