<script setup lang="ts">
import { ref, computed } from 'vue';
import { useLanguage } from '../composables/useLanguage';
import type { EmissionData } from '../types/EmissionData.ts';

const { t } = useLanguage();

const props = defineProps<{
  data: EmissionData[]
}>();

const sortKey = ref<keyof EmissionData | ''>(''); 
const sortAsc = ref(true); 

const sortBy = (key: keyof EmissionData) => {
  if (sortKey.value === key) {
    sortAsc.value = !sortAsc.value;
  } else {
    sortKey.value = key;
    sortAsc.value = true;
  }
};

const sortedData = computed(() => {
  if (!sortKey.value) return props.data;

  return [...props.data].sort((a, b) => {
    const aVal = a[sortKey.value as keyof EmissionData];
    const bVal = b[sortKey.value as keyof EmissionData];

    if (aVal === bVal) return 0;
    const modifier = sortAsc.value ? 1 : -1;
    return aVal < bVal ? -modifier : modifier;
  });
});
</script>

<template>
  <div class="overflow-x-auto">
    <table class="w-full text-start border-collapse">
      <thead>
      <tr class="bg-tertiary text-on-tertiary">

        <th
            @click="sortBy('company')"
            class="p-4 md:p-6 font-black uppercase tracking-widest cursor-pointer hover:bg-on-background-muted transition-colors select-none border-b-4 border-border text-xs md:text-sm"
        >
          {{ t('emissions.table.company') }}
          <span v-if="sortKey === 'company'" class="ms-1 md:ms-2 text-[10px] md:text-base">{{ sortAsc ? '▲' : '▼' }}</span>
        </th>

        <th
            @click="sortBy('country')"
            class="p-4 md:p-6 font-black uppercase tracking-widest cursor-pointer hover:bg-on-background-muted transition-colors select-none border-b-4 border-border text-xs md:text-sm"
        >
          {{ t('emissions.table.country') }}
          <span v-if="sortKey === 'country'" class="ms-1 md:ms-2 text-[10px] md:text-base">{{ sortAsc ? '▲' : '▼' }}</span>
        </th>

        <th
            @click="sortBy('co2')"
            class="p-4 md:p-6 font-black uppercase tracking-widest cursor-pointer hover:bg-on-background-muted transition-colors select-none border-b-4 border-border text-xs md:text-sm"
        >
          {{ t('emissions.table.co2') }}
          <span v-if="sortKey === 'co2'" class="ms-1 md:ms-2 text-[10px] md:text-base">{{ sortAsc ? '▲' : '▼' }}</span>
        </th>

      </tr>
      </thead>
      <tbody class="divide-y-4 divide-background">
      <tr
          v-for="item in sortedData"
          :key="item.id"
          class="hover:bg-border-muted/50 transition-colors"
      >
        <td class="p-3 md:p-6 text-sm md:text-xl font-black text-on-surface max-w-25 md:max-w-none truncate" :title="item.company">
          {{ item.company }}
        </td>
        <td class="p-3 md:p-6 text-xs md:text-lg font-bold text-on-background-muted max-w-20 md:max-w-none truncate" :title="item.country">
          {{ item.country }}
        </td>
        <td class="p-3 md:p-6 font-black text-base md:text-2xl text-on-surface tabular-nums text-start whitespace-nowrap">
          {{ item.co2 }}
        </td>
      </tr>

      <tr v-if="sortedData.length === 0">
        <td colspan="3" class="p-12 text-center text-on-background font-black text-2xl uppercase italic">
          {{ t('emissions.table.no_data') }}
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>