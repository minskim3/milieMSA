<template>
    <div>
        <Number
            label="글 Id"
            v-model="value.writingId"
            :editMode="editMode"
        />
        <Number
            label="작가Id"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <String
            label="작가명"
            v-model="value.authorName"
            :editMode="editMode"
        />
        <String
            label="책제목"
            v-model="value.title"
            :editMode="editMode"
        />
        <String
            label="본문"
            v-model="value.content"
            :editMode="editMode"
        />
        <String
            label="AI가 생성한 장르"
            v-model="value.aiGenre"
            :editMode="editMode"
        />
        <String
            label="AI가 생성한 표지 URL"
            v-model="value.aiCoverUrl"
            :editMode="editMode"
        />
        <String
            label="AI가 생성한 요약"
            v-model="value.aiSummary"
            :editMode="editMode"
        />
        <Date
            label="생성된 날짜"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Date
            label="수정된날짜"
            v-model="value.modifiedAt"
            :editMode="editMode"
        />
        <String
            label="출판여부"
            v-model="value.status"
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
    name: 'Writing',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "writings",
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
