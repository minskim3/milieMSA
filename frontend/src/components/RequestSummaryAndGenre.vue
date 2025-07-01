<template>

    <v-card outlined>
        <v-card-title>
            RequestSummaryAndGenre
        </v-card-title>

        <v-card-text>
            <Number label="WritingId" v-model="value.writingId" :editMode="editMode"/>
            <Number label="AuthorId" v-model="value.authorId" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <Date label="ModifiedAt" v-model="value.modifiedAt" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestSummaryAndGenre"
            >
                RequestSummaryAndGenre
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
    name: 'RequestSummaryAndGenreCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.writingId = 0;
        this.value.authorId = 0;
        this.value.content = '';
        this.value.modifiedAt = '2025-07-02';
        this.value.status = '';
    },
    watch: {
    },
    methods: {
        requestSummaryAndGenre() {
            this.$emit('requestSummaryAndGenre', this.value);
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

