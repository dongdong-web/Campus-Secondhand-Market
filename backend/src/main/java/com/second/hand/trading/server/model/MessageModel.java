package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sh_message
 * @author hjy
 */
@Data
public class MessageModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户主键id
     */
    private Long userId;

    private UserModel fromU;

    /**
     * 闲置主键id
     */
    private Long idleId;

    private IdleItemModel idle;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 留言时间
     */
    private Date createTime;

    /**
     * 所回复的用户
     */
    private Long toUser;

    private UserModel toU;

    /**
     * 所回复的留言
     */
    private Long toMessage;

    private MessageModel toM;

    private static final long serialVersionUID = 1L;
}