package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sh_address
 * @author hjy
 */
@Data
public class AddressModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 收货人姓名
     */
    private String consigneeName;

    /**
     * 收货人手机号
     */
    private String consigneePhone;

    /**
     *  宿舍类型
     */
    private String provinceName;

    /**
     * 宿舍楼
     */
    private String cityName;

    /**
     * 楼层
     */
    private String regionName;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 是否默认地址
     */
    private Boolean defaultFlag;

    /**
     * 用户主键id
     */
    private Long userId;

    // 当你一个类实现了Serializable接口，就会有显式地定义serialVersionUID
    // 序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private static final long serialVersionUID = 1L;
}