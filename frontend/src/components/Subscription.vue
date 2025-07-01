<template>
    <div>
        <Number
            label="구독이력Id"
            v-model="value.subscriptionId"
            :editMode="editMode"
        />
        <Number
            label="책Id"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <Date
            label="구독 시작 시간"
            v-model="value.startedAt"
            :editMode="editMode"
        />
        <String
            label="AccessType"
            v-model="value.accessType"
            :editMode="editMode"
        />
        <Number
            label="BookPrice"
            v-model="value.bookPrice"
            :editMode="editMode"
        />
        <UserId
            offline
            label="사용자 ID"
            v-model="value.userId"
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
    name: 'Subscription',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscriptions",
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
