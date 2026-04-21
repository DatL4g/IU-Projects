<script setup lang="ts">
import { useLanguage } from '../composables/useLanguage';
const { t, locale } = useLanguage();
</script>

<template>
  <div class="grow flex flex-col items-center justify-center p-12 bg-background text-center min-h-[60vh]">
    <h1 class="text-9xl font-black text-on-background mb-4 tracking-tighter uppercase">404</h1>
    <h2 class="text-4xl font-black text-primary mb-8 uppercase tracking-tight">{{ t('not_found.title') }}</h2>
    <p class="text-on-background text-xl font-bold max-w-md mb-12 opacity-80">
      {{ t('not_found.desc') }}
    </p>
    <router-link :to="{ name: 'home', params: { lang: locale } }" class="btn-primary">
      {{ t('not_found.back_home') }}
    </router-link>
  </div>
</template>