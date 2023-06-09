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



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", consigneeName=").append(consigneeName);
        sb.append(", consigneePhone=").append(consigneePhone);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}