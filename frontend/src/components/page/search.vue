<template>
    <div>
        <app-head :searchInput="searchValue"></app-head>

        <!-- 页面主体部分 -->
        <app-body>
            <div class="container">
                <!-- 标签页 -->
                <el-tabs v-model="labelName" type="card" @tab-click="handleClick">
                    <!-- 标签页项 -->
                    <el-tab-pane label="全部" name="0"></el-tab-pane>
                    <el-tab-pane label="数码科技" name="1"></el-tab-pane>
                    <el-tab-pane label="生活用品" name="2"></el-tab-pane>
                    <el-tab-pane label="运动相关" name="3"></el-tab-pane>
                    <el-tab-pane label="图书笔记" name="4"></el-tab-pane>
                    <el-tab-pane label="求购展示" name="5"></el-tab-pane>
                </el-tabs>

                <div class="inner-container">
                    <!-- 列表项 -->
                    <div class="no-results" v-if="idleList.length === 0">暂无匹配的闲置物品</div>
                    <el-row :gutter="30">
                        <el-col :span="6" v-for="(idle,index) in idleList" :key="index">
                            <div class="idle-card" @click="toDetails(idle)">
                                <el-image class="image" :src="idle.imgUrl" fit="contain">
                                    <div slot="error" class="image-slot">
                                        <i class="el-icon-picture-outline">无图</i>
                                    </div>
                                </el-image>
                                <div class="idle-title">{{idle.idleName}}</div>
                                <el-row class="row-style">
                                    <!-- 显示价格 -->
                                    <el-col :span="12"><div class="idle-price">￥{{idle.idlePrice}}</div></el-col>
                                    <!-- 地点信息 -->
                                    <el-col :span="12"><div class="idle-place">{{idle.idlePlace}}</div></el-col>
                                </el-row>
                                <div class="idle-time">{{idle.timeStr}}</div>
                                <div class="user-info">
                                    <el-image class="avatar" :src="idle.user.avatar" fit="contain">
                                        <div slot="error" class="image-slot">
                                            <i class="el-icon-picture-outline">无图</i>
                                        </div>
                                    </el-image>
                                    <div class="user-nickname">{{idle.user.nickname}}</div>
                                </div>
                            </div>
                        </el-col>
                    </el-row>
                </div>
                <!-- 分页组件 -->
                <div class="fenye">
                    <el-pagination
                            background
                            @current-change="handleCurrentChange"
                            :current-page.sync="currentPage"
                            :page-size="8"
                            layout="prev, pager, next, jumper"
                            :total="totalItem">
                    </el-pagination>
                </div>
            </div>
            <app-foot></app-foot>
        </app-body>
    </div>
</template>

<script>
    import AppHead from '../common/AppHeader.vue';
    import AppBody from '../common/AppPageBody.vue'
    import AppFoot from '../common/AppFoot.vue'

    export default {
        name: "search",
        components: {
            AppHead,
            AppBody,
            AppFoot
        },
        data() {
            return {
                labelName: 0,
                idleList: [],
                currentPage: 1,
                searchValue: '',
                totalItem:1
            };
        },
        created() {
            this.findIdleTiem(1, this.$route.query.searchValue);
            this.searchValue = this.$route.query.searchValue;
        },
        watch: {
            $route(to, from) {
                this.searchValue = to.query.searchValue;
                this.findIdleTiem(to.query.page, to.query.searchValue);
            }
        },
        methods: {
            async findIdleTiem(page, findValue) {
                try {
                    const res = await this.$api.findIdleTiem({
                        page: page,
                        nums: 8,
                        findValue: findValue
                    });
                    console.log(res);
                    let list = res.data.list;
                    for (let i = 0; i < list.length; i++) {
                        list[i].timeStr = list[i].releaseTime.substring(0, 10) + " " + list[i].releaseTime.substring(11, 19);
                        let pictureList = JSON.parse(list[i].pictureList);
                        list[i].imgUrl = pictureList.length > 0 ? pictureList[0] : '';
                    }
                    this.idleList = list;
                    this.totalItem = res.data.count;
                } catch (e) {
                    console.log(e);
                }
            },
            handleClick(tab, event) {
                console.log(tab, event);
                console.log(this.labelName)
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                this.$router.replace({query: {page: val, searchValue: this.searchValue}});
            },
            toDetails(idle) {
                this.$router.push({path: '/details', query: {id: idle.id}});
            }
        }
    }
</script>

<style scoped>
.container {
    min-height: 85vh;
}

.inner-container {
    margin: 0 20px;
}

.image {
    width: 100%;
    height: 160px;
}

.avatar {
    width: 30px;
    height: 30px;
}

.idle-card {
    height: 300px;
    border: #eeeeee solid 1px;
    margin-bottom: 15px;
    cursor: pointer;
    transition: all 0.3s ease;
}

.idle-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.row-style {
    margin: 5px 10px;
}

.fenye {
    display: flex;
    justify-content: center;
    height: 60px;
    align-items: center;
}

.idle-title {
    font-size: 18px;
    font-weight: 600;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    margin: 10px;
}

.idle-price {
    font-size: 16px;
    color: red;
}

.idle-place {
    font-size: 13px;
    color: #666666;
    float: right;
    padding-right: 20px;
}

.idle-time {
    color: #666666;
    font-size: 12px;
    margin: 0 10px;
}

.user-nickname {
    color: #999999;
    font-size: 12px;
    display: flex;
    align-items: center;
    height: 30px;
    padding-left: 10px;
}

.user-info {
    padding: 5px 10px;
    height: 30px;
    display: flex;
}
</style>