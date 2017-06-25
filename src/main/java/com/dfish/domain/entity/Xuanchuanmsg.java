package com.dfish.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Entity
public class Xuanchuanmsg { //宣传信息

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getIspass() {
        return ispass;
    }

    public void setIspass(String ispass) {
        this.ispass = ispass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getXcxxleibie() {
        return xcxxleibie;
    }

    public void setXcxxleibie(String xcxxliebie) {
        this.xcxxleibie = xcxxliebie;
    }

    public String getMeijie() {
        return meijie;
    }

    public void setMeijie(String meijie) {
        this.meijie = meijie;
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String title;//宣传标题

    @ManyToOne
    private User user;//申请人

    private String beizhu; //备注

    private String ispass;//审核状态

    @org.hibernate.annotations.Type(type="text")
    private String content;//内容

    private String starttime;//开始投放时间

    private String endtime;//结束投放时间

    private String applytime;//申请时间


//    @OneToOne
//    @JoinColumn(name="xcxxleibie_name")

    private String xcxxleibie;//宣传类别

    private String meijie;//媒介

    private String filepath;//附件地址

    private String filename;//附件名字

    private String advise; //领导审批意见


}
