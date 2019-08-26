package com.cry.forum.model;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class Post extends BaseEntity{
    private String title;

    private String content;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "cagetory_id")
    private String cagetoryId;

    @Column(name = "create_time")
    private Date createTime;

    private String state;


    private List<Comment> commentList;

    private List<File> fileList;

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

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
     * @return cagetory_id
     */
    public String getCagetoryId() {
        return cagetoryId;
    }

    /**
     * @param cagetoryId
     */
    public void setCagetoryId(String cagetoryId) {
        this.cagetoryId = cagetoryId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }


}