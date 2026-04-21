<script setup lang="ts">
import AppHeader from '../components/Header.vue';
import AppFooter from '../components/Footer.vue';
</script>

<template>
  <div class="min-h-screen flex flex-col bg-background text-on-background relative">
    <AppHeader />

    <main class="grow">
      <slot />
    </main>

    <AppFooter />
  </div>
</template>