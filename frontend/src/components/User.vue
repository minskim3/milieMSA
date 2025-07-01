<template>
    <div>
        <Number
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="로그인Id"
            v-model="value.loginId"
            :editMode="editMode"
        />
        <String
            label="비밀번호"
            v-model="value.password"
            :editMode="editMode"
        />
        <String
            label="이름"
            v-model="value.name"
            :editMode="editMode"
        />
        <Boolean
            label="KT 사용자 여부"
            v-model="value.isKt"
            :editMode="editMode"
        />
        <Boolean
            label="구독권 여부"
            v-model="value.isSubscribed"
            :editMode="editMode"
        />
        <Date
            label="구독권시작날짜"
            v-model="value.subscribedAt"
            :editMode="editMode"
        />
        <Date
            label="구독권 만료일"
            v-model="value.subscriptionEndAt"
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
    name: 'User',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "users",
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
