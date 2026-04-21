<script setup lang="ts">
import { useLanguage } from './composables/useLanguage';
import DefaultLayout from './layouts/DefaultLayout.vue';

useLanguage();
</script>

<template>
  <DefaultLayout>
    <router-view />
  </DefaultLayout>
</template>