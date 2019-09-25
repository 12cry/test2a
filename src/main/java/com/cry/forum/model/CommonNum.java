package com.cry.forum.model;

import javax.persistence.*;

@Table(name = "common_num")
public class CommonNum {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String code;

    private String name;

    @Column(name = "target_id")
    private String targetId;

    private Integer z1;

    private Integer z2;

    private Integer z3;

    private Integer z4;

    private Integer z5;

    private Integer z6;

    private Integer z7;

    private Integer z8;

    private Integer z9;

    private Integer z10;

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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return target_id
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * @param targetId
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    /**
     * @return z1
     */
    public Integer getZ1() {
        return z1;
    }

    /**
     * @param z1
     */
    public void setZ1(Integer z1) {
        this.z1 = z1;
    }

    /**
     * @return z2
     */
    public Integer getZ2() {
        return z2;
    }

    /**
     * @param z2
     */
    public void setZ2(Integer z2) {
        this.z2 = z2;
    }

    /**
     * @return z3
     */
    public Integer getZ3() {
        return z3;
    }

    /**
     * @param z3
     */
    public void setZ3(Integer z3) {
        this.z3 = z3;
    }

    /**
     * @return z4
     */
    public Integer getZ4() {
        return z4;
    }

    /**
     * @param z4
     */
    public void setZ4(Integer z4) {
        this.z4 = z4;
    }

    /**
     * @return z5
     */
    public Integer getZ5() {
        return z5;
    }

    /**
     * @param z5
     */
    public void setZ5(Integer z5) {
        this.z5 = z5;
    }

    /**
     * @return z6
     */
    public Integer getZ6() {
        return z6;
    }

    /**
     * @param z6
     */
    public void setZ6(Integer z6) {
        this.z6 = z6;
    }

    /**
     * @return z7
     */
    public Integer getZ7() {
        return z7;
    }

    /**
     * @param z7
     */
    public void setZ7(Integer z7) {
        this.z7 = z7;
    }

    /**
     * @return z8
     */
    public Integer getZ8() {
        return z8;
    }

    /**
     * @param z8
     */
    public void setZ8(Integer z8) {
        this.z8 = z8;
    }

    /**
     * @return z9
     */
    public Integer getZ9() {
        return z9;
    }

    /**
     * @param z9
     */
    public void setZ9(Integer z9) {
        this.z9 = z9;
    }

    /**
     * @return z10
     */
    public Integer getZ10() {
        return z10;
    }

    /**
     * @param z10
     */
    public void setZ10(Integer z10) {
        this.z10 = z10;
    }
}