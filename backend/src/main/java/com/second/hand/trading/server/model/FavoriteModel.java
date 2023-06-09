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
}