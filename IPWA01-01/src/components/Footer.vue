<script setup lang="ts">
import { useLanguage } from '../composables/useLanguage';
const { t, locale } = useLanguage();</script>

<template>
  <footer class="bg-tertiary text-on-tertiary border-t border-border shadow-lg mt-8 md:mt-12">
    <div class="w-full px-4 md:px-10 py-6 md:py-8 flex flex-col md:flex-row justify-between items-center gap-8">

      <div class="text-center md:text-start space-y-2 md:space-y-1">
        <p class="text-lg md:text-xl font-black tracking-tight uppercase">{{ t('footer.org') }}</p>
        <p class="text-on-tertiary/80 text-xs md:text-sm font-bold">{{ t('footer.tagline') }}</p>
        <p class="text-on-tertiary/40 text-[9px] md:text-[10px] font-black uppercase tracking-[0.2em] pt-1 md:pt-2">&copy; 2026 CO2 Tracker</p>
      </div>

      <nav class="flex flex-wrap justify-center gap-2 md:gap-4 text-xs md:text-sm font-black">
        <router-link :to="{ name: 'about-project', params: { lang: locale } }" class="px-3 py-2 md:px-4 md:py-2 rounded-full hover:bg-on-tertiary/10 border-2 border-transparent hover:border-on-tertiary/20 text-on-tertiary/80 hover:text-on-tertiary">{{ t('footer.project_info') }}</router-link>
        <router-link :to="{ name: 'imprint', params: { lang: locale } }" class="px-3 py-2 md:px-4 md:py-2 rounded-full hover:bg-on-tertiary/10 border-2 border-transparent hover:border-on-tertiary/20 text-on-tertiary/80 hover:text-on-tertiary">{{ t('footer.legal') }}</router-link>
      </nav>

    </div>
  </footer>
</template>