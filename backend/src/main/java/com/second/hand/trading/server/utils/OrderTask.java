package com.second.hand.trading.server.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.second.hand.trading.server.model.OrderModel;
import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
@Data
public class OrderTask implements Delayed {
    /**
     * 延迟时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private long time;

    private OrderModel orderModel;

    public OrderTask(){

    }

    public OrderTask(OrderModel orderModel, long time) {
        this.orderModel = orderModel;
        this.time = System.currentTimeMillis()+1000*time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        OrderTask Order = (OrderTask) o;
        long diff = this.time - Order.time;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"time\":")
                .append(time);
        sb.append(",\"orderModel\":")
                .append(orderModel);
        sb.append('}');
        return sb.toString();
    }
}