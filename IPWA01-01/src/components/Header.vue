<script setup lang="ts">
import {computed, ref, watch} from 'vue';
import {useRoute} from 'vue-router';
import {useScroll} from '../composables/useScroll';
import {useLanguage} from '../composables/useLanguage';
import {NAV_LINKS} from '../constants/appConstants';

const route = useRoute();
const { isScrolled } = useScroll();
const { locale, t, isRTL, toggleRTL } = useLanguage();

const isMenuOpen = ref(false);

watch(isMenuOpen, (isOpen) => {
  if (isOpen) {
    document.body.style.overflow = 'hidden';
  } else {
    document.body.style.overflow = '';
  }
});

const isHomePage = computed(() => route.name === 'home');

const headerClasses = computed(() => {
  return isHomePage.value && !isScrolled.value && !isMenuOpen.value
      ? 'absolute bg-transparent border-transparent text-on-background shadow-none'
      : 'sticky bg-tertiary text-on-tertiary border-border shadow-lg';
});</script>

<template>
  <header 
    :class="[headerClasses, 'top-0 inset-x-0 z-50 border-b transition-none']"
  >
    <div class="w-full px-4 md:px-10 py-3 md:py-4 flex justify-between items-center transition-none">

      <router-link :to="{ name: 'home', params: { lang: locale } }" class="flex items-center gap-2 md:gap-3 hover:opacity-80 z-50">
        <div 
          class="w-7 h-7 md:w-10 md:h-10 icon-mask icon-logo" 
          :class="isHomePage && !isScrolled ? 'text-on-background' : 'text-on-tertiary'"
        ></div>
        <h1 
          class="text-lg md:text-2xl font-black tracking-tight"
          :class="isHomePage && !isScrolled ? 'text-on-background' : 'text-on-tertiary'"
        >
          CO2 Tracker
        </h1>
      </router-link>

      <nav class="hidden md:flex items-center gap-6 font-medium">
        <router-link 
          v-for="link in NAV_LINKS" 
          :key="link.name" 
          :to="{ name: link.name, params: { lang: locale } }" 
          class="px-4 py-2 rounded-full transition-none"
          :class="isHomePage && !isScrolled ? 'hover:bg-on-background/10' : 'hover:bg-on-tertiary/10'"
          :exact-active-class="isHomePage && !isScrolled ? 'bg-on-background/10 shadow-inner' : 'bg-on-tertiary/20 shadow-inner'"
        >
          {{ t(`nav.${link.name}`) }}
        </router-link>

        <button 
          @click="toggleRTL" 
          class="w-10 h-10 flex items-center justify-center rounded-full transition-transform"
          :class="[
            isHomePage && !isScrolled ? 'text-on-background hover:bg-on-background/10' : 'text-on-tertiary hover:bg-on-tertiary/10',
            isRTL ? '-scale-x-100' : ''
          ]"
          title="Toggle RTL/LTR"
        >
          <div class="w-6 h-6 icon-mask icon-keyboard"></div>
        </button>

        <a href="https://github.com/DatL4g/IU-Projects" target="_blank" class="w-10 h-10 flex items-center justify-center rounded-full" :class="isHomePage && !isScrolled ? 'hover:bg-on-background/10' : 'hover:bg-on-tertiary/10'">
          <div 
            class="w-7 h-7 icon-mask icon-github" 
            :class="isHomePage && !isScrolled ? 'text-on-background' : 'text-on-tertiary'"
          ></div>
        </a>
      </nav>

      <div class="flex items-center gap-1 md:hidden z-110">
        <button 
          @click="toggleRTL" 
          class="w-10 h-10 flex items-center justify-center rounded-full transition-transform"
          :class="[
            (isHomePage && !isScrolled) && !isMenuOpen ? 'text-on-background hover:bg-on-background/10' : 'text-on-tertiary hover:bg-on-tertiary/10',
            isRTL ? '-scale-x-100' : ''
          ]"
        >
          <div class="w-6 h-6 icon-mask icon-keyboard"></div>
        </button>
        <a 
          href="https://github.com/DatL4g/IU-Projects" 
          target="_blank" 
          class="w-10 h-10 flex items-center justify-center rounded-full"
          :class="(isHomePage && !isScrolled) && !isMenuOpen ? 'hover:bg-on-background/10' : 'hover:bg-on-tertiary/10'"
        >
          <div 
            class="w-7 h-7 icon-mask icon-github" 
            :class="(isHomePage && !isScrolled) && !isMenuOpen ? 'text-on-background' : 'text-on-tertiary'"
          ></div>
        </a>
        <button 
          @click="isMenuOpen = !isMenuOpen" 
          class="w-10 h-10 flex items-center justify-center rounded-full focus:outline-none" 
          :class="(isHomePage && !isScrolled) && !isMenuOpen ? 'text-on-background hover:bg-on-background/10' : 'text-on-tertiary hover:bg-on-tertiary/10'"
        >
          <svg class="w-8 h-8" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path v-if="!isMenuOpen" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16m-7 6h7" />
            <path v-else stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
          </svg>
        </button>
      </div>

      <div v-if="isMenuOpen" class="fixed inset-0 bg-tertiary z-100 flex flex-col items-center justify-center space-y-8 md:hidden text-on-tertiary">
        <router-link 
          v-for="link in NAV_LINKS" 
          :key="link.name" 
          :to="{ name: link.name, params: { lang: locale } }" 
          @click="isMenuOpen = false"
          class="text-4xl font-black hover:text-primary transition-none uppercase tracking-tighter"
          exact-active-class="text-primary underline underline-offset-8"
        >
          {{ t(`nav.${link.name}`) }}
        </router-link>
      </div>

    </div>
  </header>
</template>

<style scoped>
</style>