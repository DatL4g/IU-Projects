export const NAV_LINKS = [
  { name: 'home', to: '/' },
  { name: 'emissions', to: '/emissions' },
  { name: 'sustainability', to: '/sustainability' },
] as const;

export const SUPPORTED_LOCALES = ['en', 'de'] as const;
export type SupportedLocale = (typeof SUPPORTED_LOCALES)[number];
export const DEFAULT_LOCALE: SupportedLocale = 'en';

/**
 * Type guard to check if a string is a SupportedLocale
 */
export function isSupportedLocale(lang: string | string[] | undefined): lang is SupportedLocale {
  if (typeof lang !== 'string') return false;
  return (SUPPORTED_LOCALES as readonly string[]).includes(lang);
}

export function getBrowserLocale(): SupportedLocale {
  const pathParts = window.location.pathname.split('/');
  const urlLang = pathParts.find(segment => isSupportedLocale(segment));
  if (urlLang && isSupportedLocale(urlLang)) {
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