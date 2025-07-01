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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="selectBestSellerDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>베스트셀러 선정
                </v-btn>
                <v-dialog v-model="selectBestSellerDialog" width="500">
                    <SelectBestSeller
                        @closeDialog="selectBestSellerDialog = false"
                        @selectBestSeller="selectBestSeller"
                    ></SelectBestSeller>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>작가명</th>
                        <th>작가 ID</th>
                        <th>장르</th>
                        <th>요약</th>
                        <th>커버 url</th>
                        <th>가격</th>
                        <th>본문</th>
                        <th>출간 날짜</th>
                        <th>구매수</th>
                        <th>구독수</th>
                        <th>구매수+구독수</th>
                        <th>IsBestSeller</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="작가명">{{ val.authorName }}</td>
                            <td class="whitespace-nowrap" label="작가 ID">{{ val.authorId }}</td>
                            <td class="whitespace-nowrap" label="장르">{{ val.genre }}</td>
                            <td class="whitespace-nowrap" label="요약">{{ val.summary }}</td>
                            <td class="whitespace-nowrap" label="커버 url">{{ val.coverUrl }}</td>
                            <td class="whitespace-nowrap" label="가격">{{ val.price }}</td>
                            <td class="whitespace-nowrap" label="본문">{{ val.content }}</td>
                            <td class="whitespace-nowrap" label="출간 날짜">{{ val.publishedDate }}</td>
                            <td class="whitespace-nowrap" label="구매수">{{ val.purchaseCount }}</td>
                            <td class="whitespace-nowrap" label="구독수">{{ val.subscriptionCount }}</td>
                            <td class="whitespace-nowrap" label="구매수+구독수">{{ val.totalReadCount }}</td>
                            <td class="whitespace-nowrap" label="IsBestSeller">{{ val.isBestSeller }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Book 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Book :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Book 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="BookId" v-model="selectedRow.bookId" :editMode="true"/>
                            <String label="작가명" v-model="selectedRow.authorName" :editMode="true"/>
                            <Number label="작가 ID" v-model="selectedRow.authorId" :editMode="true"/>
                            <String label="장르" v-model="selectedRow.genre" :editMode="true"/>
                            <String label="요약" v-model="selectedRow.summary" :editMode="true"/>
                            <String label="커버 url" v-model="selectedRow.coverUrl" :editMode="true"/>
                            <Number label="가격" v-model="selectedRow.price" :editMode="true"/>
                            <String label="본문" v-model="selectedRow.content" :editMode="true"/>
                            <Date label="출간 날짜" v-model="selectedRow.publishedDate" :editMode="true"/>
                            <Number label="구매수" v-model="selectedRow.purchaseCount" :editMode="true"/>
                            <Number label="구독수" v-model="selectedRow.subscriptionCount" :editMode="true"/>
                            <Number label="구매수+구독수" v-model="selectedRow.totalReadCount" :editMode="true"/>
                            <Boolean label="IsBestSeller" v-model="selectedRow.isBestSeller" :editMode="true"/>
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
    name: 'bookGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'books',
        selectBestSellerDialog: false,
    }),
    watch: {
    },
    methods:{
        async selectBestSeller(params){
            try{
                var path = "selectBestSeller".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','selectBestSeller 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.selectBestSellerDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>