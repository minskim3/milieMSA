import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/authors',
      component: () => import('../components/ui/AuthorGrid.vue'),
    },
    {
      path: '/writings',
      component: () => import('../components/ui/WritingGrid.vue'),
    },
    {
      path: '/coverDesigns',
      component: () => import('../components/ui/CoverDesignGrid.vue'),
    },
    {
      path: '/contentAnalyzers',
      component: () => import('../components/ui/ContentAnalyzerGrid.vue'),
    },
    {
      path: '/books',
      component: () => import('../components/ui/BookGrid.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/subscriptions',
      component: () => import('../components/ui/SubscriptionGrid.vue'),
    },
    {
      path: '/points',
      component: () => import('../components/ui/PointGrid.vue'),
    },
    {
      path: '/bookPrices',
      component: () => import('../components/BookPriceView.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/UserView.vue'),
    },
  ],
})

export default router;
