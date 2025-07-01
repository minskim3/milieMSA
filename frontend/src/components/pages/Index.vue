<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "작가",
          link: "/authors",
      },
      {
          text: "글",
          link: "/writings",
      },
      {
          text: "커버 이미지",
          link: "/coverDesigns",
      },
      {
          text: "ContentAnalyzer",
          link: "/contentAnalyzers",
      },
      {
          text: "책",
          link: "/books",
      },
      {
          text: "사용자",
          link: "/users",
      },
      {
          text: "구독이력",
          link: "/subscriptions",
      },
      {
          text: "포인트",
          link: "/points",
      },
      {
          text: "책 가격",
          link: "/bookPrices",
      },
      {
          text: "사용자정보",
          link: "/users",
      },
    ],
  }),
};
</script>
