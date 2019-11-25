package com.cry.forum.vo;

import com.cry.forum.model.File;

import java.util.Date;
import java.util.List;

public class PostVO {
    private String id;
    private String title;

    private String content;

    private String userId;

    private String categoryId;

    private Date createTime;

    private String state;

    private Boolean appreciate;
    private String avatarUrl;
    private String nickName;

    private List<CommentVO> commentVOList;

    private List<File> fileList;

    public List<CommentVO> getCommentVOList() {
        return commentVOList;
    }

    public void setCommentVOList(List<CommentVO> commentVOList) {
        this.commentVOList = commentVOList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }


}
