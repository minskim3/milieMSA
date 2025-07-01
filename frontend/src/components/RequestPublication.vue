<template>

    <v-card outlined>
        <v-card-title>
            RequestPublication
        </v-card-title>

        <v-card-text>
            <Number label="WritingId" v-model="value.writingId" :editMode="editMode"/>
            <Number label="AuthorId" v-model="value.authorId" :editMode="editMode"/>
            <String label="AuthorName" v-model="value.authorName" :editMode="editMode"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <String label="AiGenre" v-model="value.aiGenre" :editMode="editMode"/>
            <String label="AiCoverUrl" v-model="value.aiCoverUrl" :editMode="editMode"/>
            <String label="AiSummary" v-model="value.aiSummary" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="requestPublication"
            >
                RequestPublication
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
    name: 'RequestPublicationCommand',
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
        this.value.authorName = '';
        this.value.title = '';
        this.value.content = '';
        this.value.aiGenre = '';
        this.value.aiCoverUrl = '';
        this.value.aiSummary = '';
        this.value.status = '';
    },
    watch: {
    },
    methods: {
        requestPublication() {
            this.$emit('requestPublication', this.value);
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

