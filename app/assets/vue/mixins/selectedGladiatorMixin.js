export const selectedGladiatorMixin = {
  methods: {
      updateHoveredGladiator() {
          this.$store.commit('SET_HOVEREDGLADIATOR', this.gladiator);
      },
      resetHoveredGladiator() {
        this.$store.commit('SET_HOVEREDGLADIATOR', {});
      }
  }
}