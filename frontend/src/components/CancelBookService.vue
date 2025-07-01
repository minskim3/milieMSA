<template>

    <v-card outlined>
        <v-card-title>
            CancelBookService
        </v-card-title>

        <v-card-text>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Boolean label="IsSubscribed" v-model="value.isSubscribed" :editMode="editMode"/>
            <Date label="SubscriptionEndAt" v-model="value.subscriptionEndAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="cancelBookService"
            >
                CancelBookService
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
    name: 'CancelBookServiceCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = 0;
        this.value.isSubscribed = false;
        this.value.subscriptionEndAt = '2025-07-02';
    },
    watch: {
    },
    methods: {
        cancelBookService() {
            this.$emit('cancelBookService', this.value);
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

