Vue.use(Vuex);
 
const initialState = {
  controller: {},
  event: "",
  myPlayerId: null,
  myHoveredGladiator: {},
  mySelectedGladiator: {},
};

var websocket = new WebSocket("ws://localhost:9000/websocket");

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
    },
    endTurn() {
      websocket.send(JSON.stringify({"commandType": "EndTurn"}));
    },
    connectPlayer({commit}, params) {
      let oPayload = {
        "commandType" : params.id == 1 ? "NamePlayerOne": "NamePlayerTwo",
        "name": params.name
      };
      websocket.send(JSON.stringify(oPayload));
    },
    buyGladiator({commit}, coordinates) {
      let payload = {
        "commandType" : "BuyUnit",
        "number": this.state.mySelectedGladiator.shopIndex,
        "position": {"x" : coordinates.x, "y": coordinates.y}
      };
      websocket.send(JSON.stringify(payload));
    },
    moveGladiator({commit}, coordinates) {
      let oPayload = {
        "commandType" : "Move",
        "from": {
          "x": this.state.mySelectedGladiator.gladiator.position.x,
          "y": this.state.mySelectedGladiator.gladiator.position.y
        },
        "to": {
          "x" : coordinates.x,
          "y": coordinates.y
        }
      };
      websocket.send(JSON.stringify(oPayload));
    }
  },
  mutations: {
    SET_CONTROLLER(state, controller) {
      state.controller = controller
    },
    SET_EVENT(state, event) {
      state.event = event
    },
    SET_PLAYERID(state, playerId) {
      state.myPlayerId = playerId
    },
    SET_HOVEREDGLADIATOR(state, gladiator) {
      state.myHoveredGladiator = gladiator
    },
    SET_SELECTEDGLADIATOR(state, selectedGladiator) {
      state.mySelectedGladiator = selectedGladiator
    }
  },
  mounted() {
  }
});

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
  let response = JSON.parse(e.data),
      gameController = response[0],
      gameEvent = response[1];

  store.commit('SET_CONTROLLER', gameController);
  store.commit('SET_EVENT', gameEvent);

  switch(gameEvent.eventType) {
    case "Connected":
      store.commit('SET_PLAYERID', gameEvent.player);
      console.log("Connected to the game");
  }
}

export default store;