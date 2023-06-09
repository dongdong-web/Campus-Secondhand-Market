package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sh_admin
 * @author hjy
 */
@Data
public class AdminModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 管理员账号
     */
    private String accountNumber;

    /**
     * 密码
     */
    private String adminPassword;

    /**
     * 管理员名字
     */
    private String adminName;


    // 当你一个类实现了Serializable接口，就会有显式地定义serialVersionUID
    // 序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private static final long serialVersionUID = 1L;
}