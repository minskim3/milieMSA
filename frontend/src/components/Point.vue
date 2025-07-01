<template>
    <div>
        <Number
            label="포인트ID"
            v-model="value.pointId"
            :editMode="editMode"
        />
        <Number
            label="사용자ID"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Number
            label="보유한 포인트"
            v-model="value.balance"
            :editMode="editMode"
        />
        <Date
            label="마지막 업데이트 시간"
            v-model="value.lastUpdatedAt"
            :editMode="editMode"
        />
        <Number
            label="총 충전한 포인트 양"
            v-model="value.totalCharged"
            :editMode="editMode"
        />
        <Number
            label="총 사용한 포인트 양"
            v-model="value.totalUsed"
            :editMode="editMode"
        />
        <accountStatus
            offline
            label="계좌상태"
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
    name: 'Point',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "points",
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
