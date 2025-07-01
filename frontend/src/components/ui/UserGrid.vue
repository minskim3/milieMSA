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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="subscribeBookServiceDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>월정액제신청
                </v-btn>
                <v-dialog v-model="subscribeBookServiceDialog" width="500">
                    <SubscribeBookService
                        @closeDialog="subscribeBookServiceDialog = false"
                        @subscribeBookService="subscribeBookService"
                    ></SubscribeBookService>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="cancelBookServiceDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>월 정액제 취소
                </v-btn>
                <v-dialog v-model="cancelBookServiceDialog" width="500">
                    <CancelBookService
                        @closeDialog="cancelBookServiceDialog = false"
                        @cancelBookService="cancelBookService"
                    ></CancelBookService>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>로그인Id</th>
                        <th>비밀번호</th>
                        <th>이름</th>
                        <th>KT 사용자 여부</th>
                        <th>구독권 여부</th>
                        <th>구독권시작날짜</th>
                        <th>구독권 만료일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="로그인Id">{{ val.loginId }}</td>
                            <td class="whitespace-nowrap" label="비밀번호">{{ val.password }}</td>
                            <td class="whitespace-nowrap" label="이름">{{ val.name }}</td>
                            <td class="whitespace-nowrap" label="KT 사용자 여부">{{ val.isKt }}</td>
                            <td class="whitespace-nowrap" label="구독권 여부">{{ val.isSubscribed }}</td>
                            <td class="whitespace-nowrap" label="구독권시작날짜">{{ val.subscribedAt }}</td>
                            <td class="whitespace-nowrap" label="구독권 만료일">{{ val.subscriptionEndAt }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">User 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <User :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">User 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="UserId" v-model="selectedRow.userId" :editMode="true"/>
                            <String label="로그인Id" v-model="selectedRow.loginId" :editMode="true"/>
                            <String label="비밀번호" v-model="selectedRow.password" :editMode="true"/>
                            <String label="이름" v-model="selectedRow.name" :editMode="true"/>
                            <Boolean label="KT 사용자 여부" v-model="selectedRow.isKt" :editMode="true"/>
                            <Boolean label="구독권 여부" v-model="selectedRow.isSubscribed" :editMode="true"/>
                            <Date label="구독권시작날짜" v-model="selectedRow.subscribedAt" :editMode="true"/>
                            <Date label="구독권 만료일" v-model="selectedRow.subscriptionEndAt" :editMode="true"/>
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
    name: 'userGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'users',
        subscribeBookServiceDialog: false,
        cancelBookServiceDialog: false,
    }),
    watch: {
    },
    methods:{
        async subscribeBookService(params){
            try{
                var path = "subscribeBookService".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','subscribeBookService 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.subscribeBookServiceDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async cancelBookService(params){
            try{
                var path = "cancelBookService".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','cancelBookService 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.cancelBookServiceDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>