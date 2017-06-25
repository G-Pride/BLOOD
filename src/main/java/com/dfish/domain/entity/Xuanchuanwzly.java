package com.dfish.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/6/14.
 */
@Entity
public class Xuanchuanwzly {
    @Id
    @GeneratedValue
    private Long id ;
    private String applydate; //申请时间
    private String title;//宣传物资标题
    private String name;//宣传物资名称
    private String company;//单位
    private int count ;//数量
    private String usedirection;//使用方向
    private String wzbeizhu;//物资备注
    private String lysqbeizhu;//物资领用申请备注
    private String filepath;//附件地址
    private String filename;//附件名字
    private String advise; //领导审批意见
    private String ispass;//审核状态

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUsedirection() {
        return usedirection;
    }

    public void setUsedirection(String usedirection) {
        this.usedirection = usedirection;
    }

    public String getWzbeizhu() {
        return wzbeizhu;
    }

    public void setWzbeizhu(String wzbeizhu) {
        this.wzbeizhu = wzbeizhu;
    }

    public String getLysqbeizhu() {
        return lysqbeizhu;
    }

    public void setLysqbeizhu(String lysqbeizhu) {
        this.lysqbeizhu = lysqbeizhu;
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

    public String getIspass() {
        return ispass;
    }

    public void setIspass(String ispass) {
        this.ispass = ispass;
    }
}

