package com.cry.forum.model;

import javax.persistence.*;

@Table(name = "user_post")
public class UserPost extends BaseEntity{

    @Column(name = "user_id")
    private String userId;

    @Column(name = "post_id")
    private String postId;

    private Boolean appreciate;

    private Boolean collect;


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
     * @return post_id
     */
    public String getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(String postId) {
        this.postId = postId;
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
}