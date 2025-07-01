<template>
    <div>
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <String
            label="작가명"
            v-model="value.authorName"
            :editMode="editMode"
        />
        <Number
            label="작가 ID"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <String
            label="장르"
            v-model="value.genre"
            :editMode="editMode"
        />
        <String
            label="요약"
            v-model="value.summary"
            :editMode="editMode"
        />
        <String
            label="커버 url"
            v-model="value.coverUrl"
            :editMode="editMode"
        />
        <Number
            label="가격"
            v-model="value.price"
            :editMode="editMode"
        />
        <String
            label="본문"
            v-model="value.content"
            :editMode="editMode"
        />
        <Date
            label="출간 날짜"
            v-model="value.publishedDate"
            :editMode="editMode"
        />
        <Number
            label="구매수"
            v-model="value.purchaseCount"
            :editMode="editMode"
        />
        <Number
            label="구독수"
            v-model="value.subscriptionCount"
            :editMode="editMode"
        />
        <Number
            label="구매수+구독수"
            v-model="value.totalReadCount"
            :editMode="editMode"
        />
        <Boolean
            label="IsBestSeller"
            v-model="value.isBestSeller"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Book',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "books",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
