package com.cry.forum.model;

import javax.persistence.Column;
import java.util.Date;

public class Article extends BaseEntity{
    private String title;

    @Column(name = "content_short")
    private String contentShort;

    @Column(name = "image_short")
    private String imageShort;
    private int imageShortIndex;

    private String author;

    @Column(name = "public_time")
    private Date publicTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "cagetory_id")
    private String cagetoryId;

    private String state;

    @Column(name = "Importance")
    private Integer importance;

    private String content;

    public int getImageShortIndex() {
        return imageShortIndex;
    }

    public void setImageShortIndex(int imageShortIndex) {
        this.imageShortIndex = imageShortIndex;
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