<template>
  <div class="defClass">
    <h1>{{ variable }}</h1>
    <p>a toggle value: {{ toggleText }}</p>
    <button ref="button" @click="toggle">Toggle button</button>
  </div>
</template>

<script>
  import Vue from 'vue';
  export default Vue.component('FirstComponent', {
    props: {
      variable: {
        type: String,
        required: true
      }
    },
    data: function() {
      return {
        toggleValue: false
      };
    },
    computed: {
      toggleText: function() {
        if (this.toggleValue) {
          return "Sebastian";
        } else {
          return "Sascha";
        }
      }
    },
    methods: {
      toggle: function() {
        this.toggleValue = !this.toggleValue;
      }
    }
  });
</script>

<style scoped lang="scss">
  .defClass {
    display: block;
    text-align: center;
    padding: 25px 0px;
    background: white;
  }
</style>
