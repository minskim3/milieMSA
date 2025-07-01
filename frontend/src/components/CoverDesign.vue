<template>
    <div>
        <Number
            label="커버Id"
            v-model="value.coverId"
            :editMode="editMode"
        />
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
            v-model="value.penName"
            :editMode="editMode"
        />
        <String
            label="본문"
            v-model="value.content"
            :editMode="editMode"
        />
        <String
            label="이미지url"
            v-model="value.imageUrl"
            :editMode="editMode"
        />
        <Date
            label="생성된날짜"
            v-model="value.generatedAt"
            :editMode="editMode"
        />
        <GenerationStatus
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
    name: 'CoverDesign',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "coverDesigns",
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
