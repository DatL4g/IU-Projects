import { watch, onMounted, ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute } from 'vue-router';
import { isSupportedLocale } from '../constants/appConstants';

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