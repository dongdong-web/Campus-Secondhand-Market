package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sh_idle_item
 * @author hjy
 */
@Data
public class IdleItemModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 闲置物名称
     */
    private String idleName;

    /**
     * 详情
     */
    private String idleDetails;

    /**
     * 图集
     */
    private String pictureList;

    /**
     * 价格
     */
    private BigDecimal idlePrice;

    /**
     * 发货地区
     */
    private String idlePlace;

    /**
     * 分类标签
     */
    private Integer idleLabel;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 状态（发布1、下架2、删除0）
     */
    private Byte idleStatus;

    /**
     * 用户主键id
     */
    private Long userId;

    private UserModel user;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idleName=").append(idleName);
        sb.append(", idleDetails=").append(idleDetails);
        sb.append(", pictureList=").append(pictureList);
        sb.append(", idlePrice=").append(idlePrice);
        sb.append(", idlePlace=").append(idlePlace);
        sb.append(", idleLabel=").append(idleLabel);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", idleStatus=").append(idleStatus);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}