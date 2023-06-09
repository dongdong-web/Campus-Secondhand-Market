package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sh_order_address
 * @author hjy
 */
@Data
public class OrderAddressModel implements Serializable {
    private Long id;

    private Long orderId;

    private String consigneeName;

    private String consigneePhone;

    private String detailAddress;

    private static final long serialVersionUID = 1L;
}