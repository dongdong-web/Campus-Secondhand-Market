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
}