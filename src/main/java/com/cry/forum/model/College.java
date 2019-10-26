package com.cry.forum.model;

import javax.persistence.*;

public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String intro;

    private String tel;

    private String net;

    private String contacts;

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
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return net
     */
    public String getNet() {
        return net;
    }

    /**
     * @param net
     */
    public void setNet(String net) {
        this.net = net;
    }

    /**
     * @return contacts
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * @param contacts
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}