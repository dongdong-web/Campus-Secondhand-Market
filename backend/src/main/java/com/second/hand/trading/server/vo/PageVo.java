package com.second.hand.trading.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


// 通用分页对象
@Data
// 带参构造器
@AllArgsConstructor
public class PageVo <E>{
    private List<E> list;
    private int count;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"list\":")
                .append(list);
        sb.append(",\"count\":")
                .append(count);
        sb.append('}');
        return sb.toString();
    }

}
