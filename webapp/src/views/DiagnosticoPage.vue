<template>
  <div class="md-layout">
    <div class="md-layout-item md-size-20">
      <diagnostico-menu></diagnostico-menu>
    </div>
    <div class="md-layout-item"></div>
    <div class="md-layout-item md-gutter md-alignment-center">
      <diagnostico-perguntas></diagnostico-perguntas>
    </div>
  </div>
</template>

<style lang="scss" scoped>
  .md-layout-item {
    height: 850px;

    &:nth-child(1) {
      background-color: #00d0c8;
    }

    &:nth-child(2) {
      background: md-get-palette-color(grey, 200);
    }

    &:nth-child(3) {
      background: md-get-palette-color(grey, 500);
    }
  }
</style>

<script>

  import Menu from '@/components/diagnostico/Menu';
  import Perguntas from "@/components/diagnostico/Perguntas";

  export default {
    name: 'diagnostico',
    components: {
      'diagnostico-menu': Menu,
      'diagnostico-perguntas': Perguntas
    }
  }
</script>