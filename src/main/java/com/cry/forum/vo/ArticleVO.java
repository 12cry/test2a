package com.cry.forum.vo;

import java.util.Date;

public class ArticleVO {
    private String id;
    private String title;

    private String contentShort;

    private String imageShort;

    private String author;

    private Date publicTime;

    private Date createTime;

    private Date updateTime;

    private String categoryId;

    private String state;

    private Integer importance;

    private String content;
    private Integer commentNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
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
     * @return content_short
     */
    public String getContentShort() {
        return contentShort;
    }

    /**
     * @param contentShort
     */
    public void setContentShort(String contentShort) {
        this.contentShort = contentShort;
    }

    /**
     * @return image_short
     */
    public String getImageShort() {
        return imageShort;
    }

    /**
     * @param imageShort
     */
    public void setImageShort(String imageShort) {
        this.imageShort = imageShort;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return public_time
     */
    public Date getPublicTime() {
        return publicTime;
    }

    /**
     * @param publicTime
     */
    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
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

    /**
     * @return category_id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    /**
     * @return Importance
     */
    public Integer getImportance() {
        return importance;
    }

    /**
     * @param importance
     */
    public void setImportance(Integer importance) {
        this.importance = importance;
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
}
