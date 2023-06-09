package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sh_favorite
 * @author hjy
 */
@Data
public class FavoriteModel implements Serializable {
    /**
     * 自增主键id
     */
    private Long id;

    /**
     * 加入收藏的时间
     */
    private Date createTime;

    /**
     * 用户主键id
     */
    private Long userId;

    /**
     * 闲置物主键id
     */
    private Long idleId;

    private IdleItemModel idleItem;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", userId=").append(userId);
        sb.append(", idleId=").append(idleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}