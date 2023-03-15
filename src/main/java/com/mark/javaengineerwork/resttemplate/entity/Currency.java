package com.mark.javaengineerwork.resttemplate.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCY")
public class Currency {

    @Id
    private  String en;

    @Column(name = "zh")
    private  String zh;

    public String getEn() {
        return en;
    }

    public void setEn(@NonNull String en) {
        this.en = en;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }
}
