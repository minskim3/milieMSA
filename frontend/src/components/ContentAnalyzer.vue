<template>
    <div>
        <Number
            label="ContentAnalyzerId"
            v-model="value.contentAnalyzerId"
            :editMode="editMode"
        />
        <Number
            label="글 Id"
            v-model="value.writingId"
            :editMode="editMode"
        />
        <Number
            label="작가 Id"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <String
            label="AI가 생성한 요약"
            v-model="value.aiSummary"
            :editMode="editMode"
        />
        <String
            label="AI가 생성한 장르"
            v-model="value.aiGenre"
            :editMode="editMode"
        />
        <GerationStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
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
    name: 'ContentAnalyzer',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "contentAnalyzers",
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
