<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Writingmangaement' }" />
        <VerticalNavLink
            :item="{
                title: '글',
                to: '/writings',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Aimanagement' }" />
        <VerticalNavLink
            :item="{
                title: '커버 이미지',
                to: '/coverDesigns',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'ContentAnalyzer',
                to: '/contentAnalyzers',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'bookmanagement' }" />
        <VerticalNavLink
            :item="{
                title: '책',
                to: '/books',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '사용자' }" />
        <VerticalNavLink
            :item="{
                title: '사용자',
                to: '/users',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독이력',
                to: '/subscriptions',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'pointmanagement' }" />
        <VerticalNavLink
            :item="{
                title: '포인트',
                to: '/points',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '책 가격',
                to: '/bookPrices',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'BoundedContext2063' }" />
        <VerticalNavLink
            :item="{
                title: '사용자정보',
                to: '/users',
            }"
        />
    </ul>
</template>
