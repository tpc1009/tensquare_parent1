package com.tensquare.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    /**
     * `id` varchar(20) NOT NULL COMMENT 'ID',
     *   `mobile` varchar(100) DEFAULT NULL COMMENT '手机号码',
     *   `password` varchar(100) DEFAULT NULL COMMENT '密码',
     *   `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
     *   `sex` varchar(2) DEFAULT NULL COMMENT '性别',
     *   `birthday` datetime DEFAULT NULL COMMENT '出生年月日',
     *   `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
     *   `email` varchar(100) DEFAULT NULL COMMENT 'E-Mail',
     *   `regdate` datetime DEFAULT NULL COMMENT '注册日期',
     *   `updatedate` datetime DEFAULT NULL COMMENT '修改日期',
     *   `lastdate` datetime DEFAULT NULL COMMENT '最后登陆日期',
     *   `online` bigint(20) DEFAULT NULL COMMENT '在线时长（分钟）',
     *   `interest` varchar(100) DEFAULT NULL COMMENT '兴趣',
     *   `personality` varchar(100) DEFAULT NULL COMMENT '个性',
     *   `fanscount` int(20) DEFAULT NULL COMMENT '粉丝数',
     *   `followcount` int(20) DEFAULT NULL COMMENT '关注数',
     */

    private String id;
    private String mobile;
    private String password;
    private String nickname;
    private String sex;
    private java.util.Date birthday;
    private String avatar;
    private String email;
    private java.util.Date regdate;
    private java.util.Date lastdate;
    private long online;
    private String interest;
    private String personality;
    private int fanscount;
    private int followcount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    public long getOnline() {
        return online;
    }

    public void setOnline(long online) {
        this.online = online;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public int getFanscount() {
        return fanscount;
    }

    public void setFanscount(int fanscount) {
        this.fanscount = fanscount;
    }

    public int getFollowcount() {
        return followcount;
    }

    public void setFollowcount(int followcount) {
        this.followcount = followcount;
    }
}
