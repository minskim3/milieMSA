<template>

    <v-card outlined>
        <v-card-title>
            RechargePoint
        </v-card-title>

        <v-card-text>
            <Number label="PointId" v-model="value.pointId" :editMode="editMode"/>
            <Number label="Balance" v-model="value.balance" :editMode="editMode"/>
            <Date label="LastUpdatedAt" v-model="value.lastUpdatedAt" :editMode="editMode"/>
            <Number label="TotalCharged" v-model="value.totalCharged" :editMode="editMode"/>
            <accountStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="rechargePoint"
            >
                RechargePoint
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'RechargePointCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.pointId = 0;
        this.value.balance = 0;
        this.value.lastUpdatedAt = '2025-07-02';
        this.value.totalCharged = 0;
        this.value.status = {};
    },
    watch: {
    },
    methods: {
        rechargePoint() {
            this.$emit('rechargePoint', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

