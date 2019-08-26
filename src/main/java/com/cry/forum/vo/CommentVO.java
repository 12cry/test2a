package com.cry.forum.vo;

import java.util.Date;
import java.util.List;

public class CommentVO {
    private String id;
    private String pid;

    private String content;

    private String userId;

    private Date createTime;

    private String targetId;

    private String state;

    private Boolean appreciate;

    private List<CommentVO> children;

    private String avatarUrl;
    private String nickName;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getAppreciate() {
        return appreciate;
    }

    public void setAppreciate(Boolean appreciate) {
        this.appreciate = appreciate;
    }

    public List<CommentVO> getChildren() {
        return children;
    }

    public void setChildren(List<CommentVO> children) {
        this.children = children;
    }
}