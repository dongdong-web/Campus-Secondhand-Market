package com.second.hand.trading.server.vo;

import lombok.Data;

@Data
public class AliPayVo {
    //订单编号
    private String traceNo;
//    private String no;
    //订单的总金额
    private double totalAmount;
//    private double price;
    //支付的名称
    private String subject;
//    private String name;

    //支付宝交易凭证号
    private String alipayTraceNo;
}
