package com.dfish.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

@Entity
public class Xuanchuanpin {
    @Id
    @GeneratedValue
    private Long id ;
    private String applydate; //申请时间
    private String name;//宣传品名称
    private int count ;//宣传品数量
    private float price;//宣传品价格
    private String leibie;//宣传品类别
    private String title;//宣传品标题
    private String makestyle;//制作方式
    private String standard;//规格
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime finishtime;//要求完成时间
    private String finishtime;//要求完成时间
    private String Company;//制作单位
    //    @ManyToOne
//    private Company companys;//制作单位
    private String manager; //负责人
    private String companyName; //公司名称
    private String companyPhone; //公司联系方式
    private String companyLinkman; //公司联系人
    private float totalprice; //总费用
    @org.hibernate.annotations.Type(type="text")
    private String beizhu; //备注
    private String commonAdvise; //常用意见
    @org.hibernate.annotations.Type(type="text")
    private String approvalAdvise; //审批意见
//    @ManyToOne
//    private Xuanchuanmsg xuanchuanmsg;
    private String filepath;//附件地址
    private String filename;//附件名字

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMakestyle() {
        return makestyle;
    }

    public void setMakestyle(String makestyle) {
        this.makestyle = makestyle;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyLinkman() {
        return companyLinkman;
    }

    public void setCompanyLinkman(String companyLinkman) {
        this.companyLinkman = companyLinkman;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getCommonAdvise() {
        return commonAdvise;
    }

    public void setCommonAdvise(String commonAdvise) {
        this.commonAdvise = commonAdvise;
    }

    public String getApprovalAdvise() {
        return approvalAdvise;
    }

    public void setApprovalAdvise(String approvalAdvise) {
        this.approvalAdvise = approvalAdvise;
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
}
