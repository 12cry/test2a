package com.cry.forum.model;

import javax.persistence.*;

public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "college_id")
    private String collegeId;

    private String name;

    private String intro;

    private String course;

    private String target;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return college_id
     */
    public String getCollegeId() {
        return collegeId;
    }

    /**
     * @param collegeId
     */
    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

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
     * @return intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * @param intro
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * @return course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }
}