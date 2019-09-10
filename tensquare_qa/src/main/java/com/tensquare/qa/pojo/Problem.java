package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_problem")
public class Problem implements Serializable {

    /**
     *  `id` varchar(20) NOT NULL COMMENT 'ID',
     *   `title` varchar(100) DEFAULT NULL COMMENT '标题',
     *   `content` text COMMENT '内容',
     *   `createtime` datetime DEFAULT NULL COMMENT '创建日期',
     *   `updatetime` datetime DEFAULT NULL COMMENT '修改日期',
     *   `userid` varchar(20) DEFAULT NULL COMMENT '用户ID',
     *   `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
     *   `visits` bigint(20) DEFAULT NULL COMMENT '浏览量',
     *   `thumbup` bigint(20) DEFAULT NULL COMMENT '点赞数',
     *   `reply` bigint(20) DEFAULT NULL COMMENT '回复数',
     *   `solve` varchar(1) DEFAULT NULL COMMENT '是否解决',
     *   `replyname` varchar(100) DEFAULT NULL COMMENT '回复人昵称',
     *   `replytime` datetime DEFAULT NULL COMMENT '回复日期',
     */

    @Id
    private String id;

    private String title;
    private String content;
    private java.util.Date createtime;
    private java.util.Date updatetime;
    private String userid;
    private String nickname;
    private Long visits;
    private Long thumbup;
    private String reply;
    private String solve;
    private String replyname;
    private java.util.Date replytime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public Long getThumbup() {
        return thumbup;
    }

    public void setThumbup(Long thumbup) {
        this.thumbup = thumbup;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }
}
