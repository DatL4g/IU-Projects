<script setup lang="ts">
import { ref, computed } from 'vue';
import { useLanguage } from '../composables/useLanguage';
import type { EmissionData } from '../types/EmissionData.ts';
import EmissionTable from '../components/EmissionTable.vue';
import emissionsData from '../assets/emissionsData.json';

const { t } = useLanguage();

const emissions = ref<EmissionData[]>(emissionsData);

const searchQuery = ref('');
const filterType = ref<'all' | 'company' | 'country'>('all');

const filteredEmissions = computed(() => {
  const query = searchQuery.value.toLowerCase();
  
  return emissions.value.filter(item => {
    const companyMatch = item.company.toLowerCase().includes(query);
    const countryMatch = item.country.toLowerCase().includes(query);
    
    switch (filterType.value) {
      case 'company': return companyMatch;
      case 'country': return countryMatch;
      default: return companyMatch || countryMatch;
    }
  });
});
</script>

<template>
  <main class="flex-grow w-full p-6 md:p-16 text-start bg-background">

    <div class="mb-10 max-w-4xl">
      <h1 class="text-3xl md:text-6xl font-black mb-3 text-on-background uppercase tracking-tighter">{{ t('emissions.title') }}</h1>
      <p class="text-on-background-muted text-lg md:text-xl font-medium opacity-80">{{ t('emissions.desc') }}</p>
    </div>

    <div class="mb-10 space-y-6">
      <div class="max-w-xl">
        <label for="search" class="block text-xs md:text-sm font-black text-on-background-muted mb-2 uppercase tracking-widest">{{ t('emissions.filter_label') }}</label>
        <div class="relative">
          <input
              id="search"
              v-model="searchQuery"
              type="text"
              :placeholder="t('emissions.search_placeholder')"
              class="w-full px-6 md:px-8 py-4 md:py-5 border-4 border-border rounded-full shadow-bubbly focus:translate-x-[2px] focus:translate-y-[2px] rtl:focus:-translate-x-[2px] outline-none transition-all bg-surface text-base md:text-lg font-bold"
          />
        </div>
      </div>

      <div class="flex flex-wrap gap-3">
        <button 
          v-for="type in ['all', 'company', 'country'] as const" 
          :key="type"
          @click="filterType = type"
          class="btn-sm px-4 md:px-6 py-2 transition-all text-xs md:text-sm"
          :class="filterType === type ? 'btn-primary scale-105' : 'btn-secondary'"
        >
          {{ t(`emissions.filter_types.${type}`) }}
        </button>
      </div>
    </div>

    <div class="bubbly-card overflow-hidden">
      <EmissionTable :data="filteredEmissions" />
    </div>

  </main>
</template>