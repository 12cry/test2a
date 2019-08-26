package com.cry.forum.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_comment")
public class UserComment {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "comment_id")
    private String commentId;

    private Boolean appreciate;

    private Boolean collect;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return comment_id
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * @return appreciate
     */
    public Boolean getAppreciate() {
        return appreciate;
    }

    /**
     * @param appreciate
     */
    public void setAppreciate(Boolean appreciate) {
        this.appreciate = appreciate;
    }

    /**
     * @return collect
     */
    public Boolean getCollect() {
        return collect;
    }

    /**
     * @param collect
     */
    public void setCollect(Boolean collect) {
        this.collect = collect;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}