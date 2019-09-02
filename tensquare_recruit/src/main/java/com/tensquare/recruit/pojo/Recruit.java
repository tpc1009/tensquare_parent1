package com.tensquare.recruit.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_recruit")
public class Recruit implements Serializable {
/**
 *             `id` varchar(20) NOT NULL COMMENT 'ID',
 *             `jobname` varchar(100) DEFAULT NULL COMMENT '职位名称',
 *             `salary` varchar(100) DEFAULT NULL COMMENT '薪资范围',
 *             `condition` varchar(100) DEFAULT NULL COMMENT '经验要求',
 *             `education` varchar(100) DEFAULT NULL COMMENT '学历要求',
 *             `type` varchar(1) DEFAULT NULL COMMENT '任职方式',
 *             `address` varchar(100) DEFAULT NULL COMMENT '办公地址',
 *             `eid` varchar(20) DEFAULT NULL COMMENT '企业ID',
 *             `createtime` datetime DEFAULT NULL COMMENT '创建日期',
 *             `state` varchar(1) DEFAULT NULL COMMENT '状态',
 *             `url` varchar(100) DEFAULT NULL COMMENT '网址',
 *             `label` varchar(100) DEFAULT NULL COMMENT '标签',
 *             `content1` varchar(100) DEFAULT NULL COMMENT '职位描述',
 *             `content2` varchar(100) DEFAULT NULL COMMENT '职位要求',
 * }
 */
    @Id
    private String id;

    private String jobname;
    private  String salary;
    private String condition;
    private String education;
    private String type;
    private String address;
    private String eid;
    private java.util.Date createtime;
    private String state;
    private String url;
    private String label;
    private String content1;
    private String content2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }
}
