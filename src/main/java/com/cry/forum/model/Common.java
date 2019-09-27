package com.cry.forum.model;

import javax.persistence.*;

public class Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "target_id")
    private String targetId;

    private String z1;

    private String z2;

    private String z3;

    private String z4;

    private String z5;

    private String z6;

    private String z7;

    private String z8;

    private String z9;

    private String z10;

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
    public String getZ1() {
        return z1;
    }

    /**
     * @param z1
     */
    public void setZ1(String z1) {
        this.z1 = z1;
    }

    /**
     * @return z2
     */
    public String getZ2() {
        return z2;
    }

    /**
     * @param z2
     */
    public void setZ2(String z2) {
        this.z2 = z2;
    }

    /**
     * @return z3
     */
    public String getZ3() {
        return z3;
    }

    /**
     * @param z3
     */
    public void setZ3(String z3) {
        this.z3 = z3;
    }

    /**
     * @return z4
     */
    public String getZ4() {
        return z4;
    }

    /**
     * @param z4
     */
    public void setZ4(String z4) {
        this.z4 = z4;
    }

    /**
     * @return z5
     */
    public String getZ5() {
        return z5;
    }

    /**
     * @param z5
     */
    public void setZ5(String z5) {
        this.z5 = z5;
    }

    /**
     * @return z6
     */
    public String getZ6() {
        return z6;
    }

    /**
     * @param z6
     */
    public void setZ6(String z6) {
        this.z6 = z6;
    }

    /**
     * @return z7
     */
    public String getZ7() {
        return z7;
    }

    /**
     * @param z7
     */
    public void setZ7(String z7) {
        this.z7 = z7;
    }

    /**
     * @return z8
     */
    public String getZ8() {
        return z8;
    }

    /**
     * @param z8
     */
    public void setZ8(String z8) {
        this.z8 = z8;
    }

    /**
     * @return z9
     */
    public String getZ9() {
        return z9;
    }

    /**
     * @param z9
     */
    public void setZ9(String z9) {
        this.z9 = z9;
    }

    /**
     * @return z10
     */
    public String getZ10() {
        return z10;
    }

    /**
     * @param z10
     */
    public void setZ10(String z10) {
        this.z10 = z10;
    }
}