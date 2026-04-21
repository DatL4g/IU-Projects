<script setup lang="ts">
import { useLanguage } from '../composables/useLanguage';
const { t, locale } = useLanguage();
</script>

<template>
  <main class="grow w-full p-6 md:p-16 text-start bg-background">
    <div class="max-w-5xl mx-auto space-y-12 md:space-y-16">

      <section class="space-y-4 md:space-y-6 text-center md:text-start">
        <h1 class="text-4xl md:text-8xl font-black text-on-background leading-[0.9] tracking-tighter">
          {{ t('sustainability.title') }} <br/>
          <span class="text-primary">{{ t('sustainability.subtitle') }}</span>
        </h1>
        <p class="text-lg md:text-2xl text-on-background-muted font-medium opacity-80 max-w-2xl">
          {{ t('sustainability.intro') }}
        </p>
      </section>

      <section class="grid grid-cols-1 lg:grid-cols-2 gap-8 md:gap-12 pt-4 md:pt-8">
        <div class="bubbly-card p-6 md:p-8 lg:p-10 space-y-6 md:space-y-8 -rotate-1 lg:-rotate-2 rtl:rotate-1 lg:rtl:rotate-2">
          <div class="flex items-center gap-4 md:gap-6">
            <div class="w-12 h-12 md:w-16 shrink-0 bg-border-muted border-4 border-border rounded-full flex items-center justify-center">
              <div class="w-6 h-6 md:w-8 md:h-8 icon-mask icon-logo text-on-surface"></div>
            </div>
            <h2 class="text-xl md:text-2xl lg:text-3xl font-black text-on-surface uppercase tracking-tight leading-tight">{{ t('sustainability.why_title') }}</h2>
          </div>
          <p class="text-on-surface text-base md:text-lg font-bold leading-relaxed">
            {{ t('sustainability.why_desc') }}
          </p>
        </div>

        <div class="bubbly-card p-6 md:p-8 lg:p-10 space-y-6 md:space-y-8 rotate-1 lg:rotate-2 rtl:-rotate-1 lg:rtl:-rotate-2">
          <div class="flex items-center gap-4 md:gap-6">
            <div class="w-12 h-12 md:w-16 shrink-0 bg-border-muted border-4 border-border rounded-full flex items-center justify-center">
              <div class="w-6 h-6 md:w-8 md:h-8 icon-mask icon-logo text-on-surface"></div>
            </div>
            <h2 class="text-xl md:text-2xl lg:text-3xl font-black text-on-surface uppercase tracking-tight leading-tight">{{ t('sustainability.measure_title') }}</h2>
          </div>
          <p class="text-on-surface text-base md:text-lg font-bold leading-relaxed">
            {{ t('sustainability.measure_desc') }}
          </p>
        </div>
      </section>

      <section class="bubbly-card p-8 md:p-12 lg:p-20 flex flex-col lg:flex-row items-center justify-between gap-8 md:gap-10 bg-surface">
        <div class="space-y-4 text-center lg:text-start">
          <h3 class="text-3xl md:text-5xl font-black text-on-surface leading-tight uppercase tracking-tighter">{{ t('sustainability.cta_title') }}</h3>
          <p class="text-on-surface text-lg md:text-xl font-bold opacity-90">{{ t('sustainability.cta_desc') }}</p>
        </div>
        <router-link :to="{ name: 'emissions', params: { lang: locale } }" class="btn-primary btn-lg w-full lg:w-auto">
          {{ t('nav.emissions') }}
        </router-link>
      </section>

    </div>
  </main>
</template>