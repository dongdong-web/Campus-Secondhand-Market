<template>
    <div class="login-container">
        <el-card class="box-card">
            <div class="login-body">
                <div class="login-title" @click="toIndex">校园二手商城系统</div>

                <el-form ref="form" :model="userForm">
                    <div class="input-container">
                        <el-input placeholder="请输入手机号..." v-model="userForm.accountNumber" :maxlength="11" class="login-input" @input="handleInput">
                            <template slot="prepend">
                                <div class="el-icon-user-solid"></div>
                            </template>
                        </el-input>
                        <span class="input-count">{{ userForm.accountNumber.length }}/{{ 11 }}</span>
                    </div>


                    <el-input placeholder="请输入密码..." v-model="userForm.userPassword" class="login-input"
                              @keyup.enter.native="login"  show-password>
                        <template slot="prepend">
                            <div class="el-icon-lock"></div>
                        </template>
                    </el-input>


                    <div class="login-submit">
                        <el-button type="primary" @click="login">登录</el-button>
                    </div>

                    <div class="other-submit">
                        <router-link to="/sign-in" class="sign-in-text">注册</router-link>
                        <router-link to="/login-admin" class="sign-in-text">管理员登录</router-link>

                    </div>

<!--                    背景图-->
                    <div id="image-preload">
                        <img class="preload-image" src="../../assets/background.jpg" alt="Preload Image">
                    </div>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "login",
        data() {
            return {
                userForm: {
                    accountNumber: '',
                    userPassword: ''
                },
            };
        },
        mounted() {
            this.loadBackground();
        },

        methods: {
            loadBackground() {
                const image = new Image();
                image.src = '../../assets/background-image.jpg';
                image.onload = () => {
                    // 背景图加载完成后的操作，例如设置背景样式
                };
            },

            handleInput() {
                if (this.userForm.accountNumber.length > 11) {
                    this.userForm.accountNumber = this.userForm.accountNumber.slice(0, 11);
                }
            },

            login() {
                if(this.userForm.userPassword.length === 0)  {
                    this.$message.error('请输入密码！')
                    return;
                }

                if (this.userForm.accountNumber.length !== 11) {
                    this.$message.error('手机号必须是11位');
                    return;
                }

                this.$api.userLogin({
                    accountNumber: this.userForm.accountNumber,
                    userPassword: this.userForm.userPassword
                }).then(res => {
                    console.log(res);
                    if (res.status_code === 1) {
                        res.data.signInTime=res.data.signInTime.substring(0,10);
                        this.$globalData.userInfo = res.data;
                        this.$router.replace({path: '/index'});
                    } else {
                        this.$message.error(res.msg);
                    }
                });
            },
            toIndex() {
                this.$router.replace({path: '/index'});
            }
        }
    }
</script>

<style scoped>

    .preload-image {
        position: absolute;
        top: -9999px;
        left: -9999px;
        visibility: hidden;
    }

    /*弹窗样式*/
    .login-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        width: 100%;
        background-color: #f1f1f1;
        background-image: url('../../assets/background.jpg'); /* 背景图的URL */
        background-size: cover; /* 背景图的适应方式 */
    }

    .login-body {
        padding: 30px;
        width: 400px;
        height: 100%;
    }

    .login-title {
        padding-bottom: 30px;
        text-align: center;
        font-weight: 600;
        font-size: 20px;
        color: #409EFF;
        cursor: pointer;
    }

    .login-input {
        margin-bottom: 20px;
    }

    .login-submit {
        display: flex;
        justify-content: center;
    }

    .sign-in-text {
        color: #409EFF;
        font-size: 16px;
        text-decoration: none;
        line-height:28px;
    }
    .other-submit{
        display:flex;
        justify-content: space-between;
        margin-top: 10px;
    }

    .input-count {
        position: absolute;
        right: 10px;
        top: 30%;
        transform: translateY(-50%);
        color: #888;
        font-size: 12px;
    }

    .input-container {
        position: relative;
    }
</style>