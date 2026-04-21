import { watch, onMounted, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute } from 'vue-router';
import { DEFAULT_LOCALE, isSupportedLocale, type SupportedLocale } from '../constants/appConstants';

const isRTL = ref(false);

export function useLanguage() {
  const { locale, t } = useI18n();
  const route = useRoute();

  const syncHtmlLang = () => {
    document.documentElement.lang = locale.value;
    const rtlLocales = ['ar', 'he', 'fa', 'ur'];
    const shouldBeRTL = rtlLocales.includes(locale.value) || isRTL.value;
    document.documentElement.dir = shouldBeRTL ? 'rtl' : 'ltr';
  };

  const toggleRTL = () => {
    isRTL.value = !isRTL.value;
    syncHtmlLang();
  };

  watch(() => route.params.lang, (newLang) => {
    const lang = Array.isArray(newLang) ? newLang[0] : newLang;
    if (isSupportedLocale(lang)) {
      locale.value = lang;
      syncHtmlLang();
    }
  }, { immediate: true });

  onMounted(syncHtmlLang);

  return {
    locale,
    t,
    isRTL,
    toggleRTL
  };
}

export function getBrowserLocale(): SupportedLocale {

  const pathParts = window.location.pathname.split('/');
  const urlLang = pathParts[1];
  if (isSupportedLocale(urlLang)) {
    return urlLang;
  }

  const navigatorLocale =
    navigator.languages !== undefined
      ? navigator.languages[0]
      : navigator.language;

  if (!navigatorLocale) return DEFAULT_LOCALE;

  const trimmedLocale = navigatorLocale.trim().split(/[-_]/)[0];
  if (isSupportedLocale(trimmedLocale)) {
    return trimmedLocale;
  }

  return DEFAULT_LOCALE;
}