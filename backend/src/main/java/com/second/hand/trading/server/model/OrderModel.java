package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sh_order
 * @author hjy
 */
@Data
public class OrderModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 用户主键id
     */
    private Long userId;

    private UserModel user;

    /**
     * 闲置物品主键id
     */
    private Long idleId;

    private IdleItemModel idleItem;
    /**
     * 订单总价
     */
    private BigDecimal orderPrice;

    /**
     * 支付状态
     */
    private Byte paymentStatus;

    /**
     * 支付方式
     */
    private String paymentWay;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date paymentTime;

    /**
     * 订单状态
     */
    private Byte orderStatus;

    /**
     * 是否删除
     */
    private Byte isDeleted;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", userId=").append(userId);
        sb.append(", idleId=").append(idleId);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", paymentWay=").append(paymentWay);
        sb.append(", createTime=").append(createTime);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}