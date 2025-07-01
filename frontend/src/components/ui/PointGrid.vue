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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="rechargePointDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>포인트 충전
                </v-btn>
                <v-dialog v-model="rechargePointDialog" width="500">
                    <RechargePoint
                        @closeDialog="rechargePointDialog = false"
                        @rechargePoint="rechargePoint"
                    ></RechargePoint>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>사용자ID</th>
                        <th>보유한 포인트</th>
                        <th>마지막 업데이트 시간</th>
                        <th>총 충전한 포인트 양</th>
                        <th>총 사용한 포인트 양</th>
                        <th>계좌상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="사용자ID">{{ val.userId }}</td>
                            <td class="whitespace-nowrap" label="보유한 포인트">{{ val.balance }}</td>
                            <td class="whitespace-nowrap" label="마지막 업데이트 시간">{{ val.lastUpdatedAt }}</td>
                            <td class="whitespace-nowrap" label="총 충전한 포인트 양">{{ val.totalCharged }}</td>
                            <td class="whitespace-nowrap" label="총 사용한 포인트 양">{{ val.totalUsed }}</td>
                            <td class="whitespace-nowrap" label="계좌상태">{{ val.status }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Point 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Point :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Point 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="포인트ID" v-model="selectedRow.pointId" :editMode="true"/>
                            <Number label="사용자ID" v-model="selectedRow.userId" :editMode="true"/>
                            <Number label="보유한 포인트" v-model="selectedRow.balance" :editMode="true"/>
                            <Date label="마지막 업데이트 시간" v-model="selectedRow.lastUpdatedAt" :editMode="true"/>
                            <Number label="총 충전한 포인트 양" v-model="selectedRow.totalCharged" :editMode="true"/>
                            <Number label="총 사용한 포인트 양" v-model="selectedRow.totalUsed" :editMode="true"/>
                            <accountStatus offline label="계좌상태" v-model="selectedRow.status" :editMode="true"/>
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
    name: 'pointGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'points',
        rechargePointDialog: false,
    }),
    watch: {
    },
    methods:{
        async rechargePoint(params){
            try{
                var path = "rechargePoint".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','rechargePoint 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.rechargePointDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>