import { ref, onMounted, onUnmounted } from 'vue';

export function useScroll(threshold = 50) {
  const isScrolled = ref(false);

  const handleScroll = () => {
    isScrolled.value = window.scrollY > threshold;
  };

  onMounted(() => {
    window.addEventListener('scroll', handleScroll, { passive: true });
    handleScroll();
  });

  onUnmounted(() => {
    window.removeEventListener('scroll', handleScroll);
  });

  return { isScrolled };
}