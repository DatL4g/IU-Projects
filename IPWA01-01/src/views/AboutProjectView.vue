<script setup lang="ts">
import { useLanguage } from '../composables/useLanguage';
const { t, locale } = useLanguage();
</script>

<template>
  <main class="grow w-full p-6 md:p-16 text-start bg-background">
    <div class="max-w-4xl mx-auto space-y-8 md:space-y-12">

      <section class="space-y-4 md:space-y-6">
        <h1 class="text-4xl md:text-8xl font-black text-on-background leading-[0.9] tracking-tighter uppercase">
          {{ t('about_project.title') }}
        </h1>
        <p class="text-xl md:text-2xl text-on-background-muted font-medium opacity-80">
          {{ t('about_project.subtitle') }}
        </p>
      </section>

      <section class="bubbly-card p-6 md:p-16 space-y-10 md:space-y-12 bg-surface">

        <div class="flex flex-col md:flex-row items-center gap-6 md:gap-10 pb-8 md:pb-12 border-b-4 border-background">
          <div class="relative">
            <div class="absolute inset-0 bg-primary rounded-full translate-x-1 translate-y-1 md:translate-x-2 md:translate-y-2"></div>
            <img 
              src="https://avatars.githubusercontent.com/u/46448715?v=4" 
              alt="Jeff Retz" 
              class="w-24 h-24 md:w-48 md:h-48 rounded-full border-4 border-border relative z-10 object-cover"
            />
          </div>
          <div class="space-y-3 md:space-y-4 text-center md:text-start grow">
            <p class="text-[10px] md:text-sm font-black text-primary uppercase tracking-[0.2em] md:tracking-[0.3em]">{{ t('about_project.creator_label') }}</p>
            <h2 class="text-3xl md:text-6xl font-black text-on-surface uppercase tracking-tighter">Jeff Retz</h2>
            <div class="flex flex-wrap justify-center md:justify-start gap-4 pt-1 md:pt-2">
              <a href="https://github.com/DatL4g" target="_blank" class="btn-primary btn-sm w-full sm:w-auto">
                <div class="w-4 h-4 md:w-5 md:h-5 icon-mask icon-github text-on-primary"></div>
                {{ t('about_project.personal_github') }}
              </a>
            </div>
          </div>
        </div>

        <div class="space-y-4 md:space-y-6">
          <div class="inline-block bg-border-muted text-on-background px-3 py-1.5 md:px-4 md:py-2 rounded-full font-black uppercase tracking-widest text-[10px] md:text-sm border-2 border-border">
            {{ t('about_project.case_study_label') }}
          </div>
          <h2 class="text-2xl md:text-3xl font-black text-on-surface uppercase tracking-tight">{{ t('about_project.overview_header') }}</h2>
          <p class="text-on-surface text-base md:text-lg font-bold leading-relaxed">
            {{ t('about_project.university_info') }}
          </p>
        </div>

        <div class="pt-8 md:pt-10 border-t-4 border-background space-y-4 md:space-y-6">
          <h2 class="text-2xl md:text-3xl font-black text-on-surface uppercase tracking-tight">{{ t('about_project.task_header') }}</h2>
          <p class="text-on-surface text-base md:text-lg font-bold leading-relaxed">
            {{ t('about_project.task_placeholder') }}
          </p>
        </div>

        <div class="flex flex-col sm:flex-row gap-4 md:gap-6">
          <router-link :to="{ name: 'home', params: { lang: locale } }" class="btn-secondary w-full sm:w-auto">
            &larr; {{ t('not_found.back_home') }}
          </router-link>
          <a href="https://github.com/DatL4g/IU-Projects" target="_blank" class="btn-primary w-full sm:w-auto">
            <div class="w-5 h-5 md:w-6 md:h-6 icon-mask icon-github text-on-primary"></div>
            {{ t('about_project.project_github') }}
          </a>
        </div>
      </section>

    </div>
  </main>
</template>