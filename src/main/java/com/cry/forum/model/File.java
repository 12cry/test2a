package com.cry.forum.model;

import javax.persistence.Column;
import java.util.Date;

public class File extends BaseEntity{

    private String name;

    @Column(name = "biz_id")
    private String bizId;

    private String url;

    private String type;

    private Long size;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return biz_id
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * @param bizId
     */
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return size
     */
    public Long getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Long size) {
        this.size = size;
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
}