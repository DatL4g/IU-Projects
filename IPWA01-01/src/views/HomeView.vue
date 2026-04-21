<script setup lang="ts">
import { useLanguage } from '../composables/useLanguage';
const { t, locale } = useLanguage();
</script>

<template>
  <div class="min-h-screen w-full flex flex-col relative bg-background text-on-background">

    <section class="min-h-screen w-full flex flex-col lg:flex-row items-center justify-center px-6 md:px-20 py-20 gap-8 lg:gap-24 relative z-10">
      <div class="w-full lg:w-1/2 space-y-8 text-center lg:text-start order-2 lg:order-1">
        <h1 class="text-4xl md:text-7xl lg:text-8xl font-black leading-[0.85] tracking-tighter uppercase">
          {{ t('home.hero_title') }} <br/>
          <span class="text-primary">{{ t('home.hero_subtitle') }}</span>
        </h1>
        <p class="text-xl md:text-2xl text-on-background-muted font-bold max-w-lg mx-auto lg:mx-0">
          {{ t('home.hero_desc') }}
        </p>
        <div class="flex flex-wrap justify-center lg:justify-start gap-4 md:gap-8">
          <router-link :to="{ name: 'emissions', params: { lang: locale } }" class="btn-primary btn-lg w-full sm:w-auto">
            {{ t('home.view_analytics') }}
          </router-link>
          <router-link :to="{ name: 'sustainability', params: { lang: locale } }" class="btn-secondary btn-lg w-full sm:w-auto">
            {{ t('home.mission') }}
          </router-link>
        </div>
      </div>
      <div class="w-full lg:w-1/2 flex justify-center items-center order-1 lg:order-2">
        <img src="/src/assets/undraw_the-world-is-mine_wnib.svg" alt="CO2 Tracking Illustration" class="w-full max-w-xs md:max-w-lg lg:max-w-2xl h-auto drop-shadow-[0_35px_35px_rgba(6,78,59,0.3)] animate-float" />
      </div>
    </section>

    <main class="w-full p-6 md:p-20 relative z-10">
      <div class="max-w-4xl mx-auto bubbly-card p-8 md:p-16 space-y-6 md:space-y-8 text-center bg-surface">
        <h2 class="text-3xl md:text-5xl font-black text-on-surface">{{ t('home.why_title') }}</h2>
        <p class="text-on-surface text-lg md:text-2xl font-medium leading-relaxed">
          {{ t('home.why_desc') }}
        </p>
        <router-link :to="{ name: 'emissions', params: { lang: locale } }" class="btn-secondary w-full sm:w-auto">
          {{ t('home.go_to_emissions') }} &rarr;
        </router-link>
      </div>
    </main>

  </div>
</template>

<style scoped>
</style>