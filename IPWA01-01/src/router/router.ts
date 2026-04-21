import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import EmissionsView from '../views/EmissionsView.vue';
import SustainabilityView from '../views/SustainabilityView.vue';
import ImprintView from '../views/ImprintView.vue';
import AboutProjectView from '../views/AboutProjectView.vue';
import NotFoundView from '../views/NotFoundView.vue';
import { DEFAULT_LOCALE } from '../constants/appConstants';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/:lang(en|de)',
    children: [
      {
        path: '',
        name: 'home',
        component: HomeView,
      },
      {
        path: 'emissions',
        name: 'emissions',
        component: EmissionsView,
      },
      {
        path: 'sustainability',
        name: 'sustainability',
        component: SustainabilityView,
      },
      {
        path: 'imprint',
        name: 'imprint',
        component: ImprintView,
      },
      {
        path: 'about',
        name: 'about-project',
        component: AboutProjectView,
      },
      {
        path: ':pathMatch(.*)*',
        name: 'not-found',
        component: NotFoundView,
      },
    ]
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: () => {
      return { name: 'home', params: { lang: DEFAULT_LOCALE } };
    }
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
  scrollBehavior() {
    return { top: 0 };
  },
});

export default router;