package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sh_user
 * @author hjy
 */
@Data
public class UserModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 账号（手机号）
     */
    private String accountNumber;

    /**
     * 登录密码
     */
    private String userPassword;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    private Date signInTime;

    private Byte userStatus;

    private static final long serialVersionUID = 1L;
}