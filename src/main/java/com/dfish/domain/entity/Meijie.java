package com.dfish.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/6/11 0011.
 */
@Entity
public class Meijie {

    @Id
    private  String  name;

    private String description;


    private String state;//状态

    private String lastchangetime;//开始投放时间

    public Meijie() {
    }

    private String createman;//创建人


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastchangetime() {
        return lastchangetime;
    }

    public void setLastchangetime(String lastchangetime) {
        this.lastchangetime = lastchangetime;
    }

    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }



//    @ManyToMany(mappedBy = "meijies")
//    private Set<xcleibie> xcleibie = new HashSet<>();

}
