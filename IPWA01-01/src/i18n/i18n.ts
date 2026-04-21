import { createI18n } from 'vue-i18n';
import en from './locales/en.json';
import de from './locales/de.json';
import { getBrowserLocale } from '../composables/useLanguage';

const i18n = createI18n({
  legacy: false,
  locale: getBrowserLocale(),
  fallbackLocale: 'en',
  messages: {
    en,
    de,
  },
});

export default i18n;