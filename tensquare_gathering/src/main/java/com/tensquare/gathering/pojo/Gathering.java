package com.tensquare.gathering.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_gathering")
public class Gathering {

    /**
     *   `id` varchar(20) NOT NULL COMMENT '编号',
     *   `name` varchar(100) DEFAULT NULL COMMENT '活动名称',
     *   `summary` text COMMENT '大会简介',
     *   `detail` text COMMENT '详细说明',
     *   `sponsor` varchar(100) DEFAULT NULL COMMENT '主办方',
     *   `image` varchar(100) DEFAULT NULL COMMENT '活动图片',
     *   `starttime` datetime DEFAULT NULL COMMENT '开始时间',
     *   `endtime` datetime DEFAULT NULL COMMENT '截止时间',
     *   `address` varchar(100) DEFAULT NULL COMMENT '举办地点',
     *   `enrolltime` datetime DEFAULT NULL COMMENT '报名截止',
     *   `state` varchar(1) DEFAULT NULL COMMENT '是否可见',
     *   `city` varchar(20) DEFAULT NULL COMMENT '城市',
     */

    private String id;
    private String name;
    private String summary;
    private String detail;
    private String sponsor;
    private String image;
    private java.util.Date starttime;
    private java.util.Date endtime;
    private String address;
    private java.util.Date enrolltime;
    private String state;
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrolltime() {
        return enrolltime;
    }

    public void setEnrolltime(Date enrolltime) {
        this.enrolltime = enrolltime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
