<script setup lang="ts">
import { useLanguage } from '../composables/useLanguage';
const { t, locale } = useLanguage();
</script>

<template>
  <main class="grow w-full p-6 md:p-16 text-start bg-background">
    <div class="max-w-4xl mx-auto space-y-8 md:space-y-12">

      <section class="space-y-4 md:space-y-6">
        <h1 class="text-4xl md:text-8xl font-black text-on-background leading-[0.9] tracking-tighter uppercase">
          {{ t('imprint.title') }}
        </h1>
        <p class="text-xl md:text-2xl text-on-background-muted font-medium opacity-80">
          {{ t('imprint.subtitle') }}
        </p>
      </section>

      <section class="bubbly-card p-6 md:p-16 space-y-8 md:space-y-10 bg-surface">
        <div class="space-y-4">
          <h2 class="text-2xl md:text-3xl font-black text-on-surface uppercase tracking-tight">{{ t('imprint.legal_header') }}</h2>
          <p class="text-on-surface text-base md:text-lg font-bold leading-relaxed whitespace-pre-line">
            {{ t('imprint.placeholder_text') }}
          </p>
        </div>

        <div class="pt-8 md:pt-10 border-t-4 border-background space-y-6">
          <div class="grid md:grid-cols-2 gap-8">
            <div class="space-y-2">
              <p class="text-[10px] md:text-sm font-black text-primary uppercase tracking-widest">{{ t('imprint.address') }}</p>
              <p class="text-base md:text-lg font-bold text-on-surface">Green Data Street 42<br/>12345 Eco City<br/>Earth</p>
            </div>
            <div class="space-y-2">
              <p class="text-[10px] md:text-sm font-black text-primary uppercase tracking-widest">{{ t('imprint.contact') }}</p>
              <p class="text-base md:text-lg font-bold text-on-surface">{{ t('imprint.phone') }}: +1 234 567 890<br/>{{ t('imprint.email') }}: hello@co2tracker.org</p>
            </div>
          </div>
        </div>

        <div class="flex flex-col sm:flex-row gap-4 md:gap-6">
          <router-link :to="{ name: 'home', params: { lang: locale } }" class="btn-secondary w-full sm:w-auto">
            &larr; {{ t('not_found.back_home') }}
          </router-link>
          <router-link :to="{ name: 'about-project', params: { lang: locale } }" class="btn-primary w-full sm:w-auto">
            {{ t('footer.project_info') }}
          </router-link>
        </div>
      </section>

    </div>
  </main>
</template>