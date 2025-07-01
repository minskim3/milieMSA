<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="requestPublicationDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>책 출간 요청
                </v-btn>
                <v-dialog v-model="requestPublicationDialog" width="500">
                    <RequestPublication
                        @closeDialog="requestPublicationDialog = false"
                        @requestPublication="requestPublication"
                    ></RequestPublication>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="requestCoverDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>커버 요청
                </v-btn>
                <v-dialog v-model="requestCoverDialog" width="500">
                    <RequestCover
                        @closeDialog="requestCoverDialog = false"
                        @requestCover="requestCover"
                    ></RequestCover>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="requestSummaryAndGenreDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>요약 및 장르 요청
                </v-btn>
                <v-dialog v-model="requestSummaryAndGenreDialog" width="500">
                    <RequestSummaryAndGenre
                        @closeDialog="requestSummaryAndGenreDialog = false"
                        @requestSummaryAndGenre="requestSummaryAndGenre"
                    ></RequestSummaryAndGenre>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>작가Id</th>
                        <th>작가명</th>
                        <th>책제목</th>
                        <th>본문</th>
                        <th>AI가 생성한 장르</th>
                        <th>AI가 생성한 표지 URL</th>
                        <th>AI가 생성한 요약</th>
                        <th>생성된 날짜</th>
                        <th>수정된날짜</th>
                        <th>출판여부</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="작가Id">{{ val.authorId }}</td>
                            <td class="whitespace-nowrap" label="작가명">{{ val.authorName }}</td>
                            <td class="whitespace-nowrap" label="책제목">{{ val.title }}</td>
                            <td class="whitespace-nowrap" label="본문">{{ val.content }}</td>
                            <td class="whitespace-nowrap" label="AI가 생성한 장르">{{ val.aiGenre }}</td>
                            <td class="whitespace-nowrap" label="AI가 생성한 표지 URL">{{ val.aiCoverUrl }}</td>
                            <td class="whitespace-nowrap" label="AI가 생성한 요약">{{ val.aiSummary }}</td>
                            <td class="whitespace-nowrap" label="생성된 날짜">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="수정된날짜">{{ val.modifiedAt }}</td>
                            <td class="whitespace-nowrap" label="출판여부">{{ val.status }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Writing 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Writing :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Writing 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="글 Id" v-model="selectedRow.writingId" :editMode="true"/>
                            <Number label="작가Id" v-model="selectedRow.authorId" :editMode="true"/>
                            <String label="작가명" v-model="selectedRow.authorName" :editMode="true"/>
                            <String label="책제목" v-model="selectedRow.title" :editMode="true"/>
                            <String label="본문" v-model="selectedRow.content" :editMode="true"/>
                            <String label="AI가 생성한 장르" v-model="selectedRow.aiGenre" :editMode="true"/>
                            <String label="AI가 생성한 표지 URL" v-model="selectedRow.aiCoverUrl" :editMode="true"/>
                            <String label="AI가 생성한 요약" v-model="selectedRow.aiSummary" :editMode="true"/>
                            <Date label="생성된 날짜" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="수정된날짜" v-model="selectedRow.modifiedAt" :editMode="true"/>
                            <String label="출판여부" v-model="selectedRow.status" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'writingGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'writings',
        requestPublicationDialog: false,
        requestCoverDialog: false,
        requestSummaryAndGenreDialog: false,
    }),
    watch: {
    },
    methods:{
        async requestPublication(params){
            try{
                var path = "requestPublication".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','requestPublication 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestPublicationDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async requestCover(params){
            try{
                var path = "requestCover".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','requestCover 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestCoverDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async requestSummaryAndGenre(params){
            try{
                var path = "requestSummaryAndGenre".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','requestSummaryAndGenre 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestSummaryAndGenreDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>