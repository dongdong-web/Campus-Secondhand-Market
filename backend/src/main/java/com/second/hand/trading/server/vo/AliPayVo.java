package com.second.hand.trading.server.vo;

import lombok.Data;

@Data
public class AliPayVo {
    //订单编号
    private String traceNo;
    //订单的总金额
    private double totalAmount;
    //支付的名称
    private String subject;

    //支付宝交易凭证号
    private String alipayTraceNo;
}
