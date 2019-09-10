package com.tensquare.article.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_article")
public class Article implements Serializable {

    /**
     * `id` varchar(20) NOT NULL COMMENT 'ID',
     *   `columnid` varchar(20) DEFAULT NULL COMMENT '专栏ID',
     *   `userid` varchar(20) DEFAULT NULL COMMENT '用户ID',
     *   `title` varchar(100) DEFAULT NULL COMMENT '标题',
     *   `content` text COMMENT '文章正文',
     *   `image` varchar(100) DEFAULT NULL COMMENT '文章封面',
     *   `createtime` datetime DEFAULT NULL COMMENT '发表日期',
     *   `updatetime` datetime DEFAULT NULL COMMENT '修改日期',
     *   `ispublic` varchar(1) DEFAULT NULL COMMENT '是否公开',
     *   `istop` varchar(1) DEFAULT NULL COMMENT '是否置顶',
     *   `visits` int(20) DEFAULT NULL COMMENT '浏览量',
     *   `thumbup` int(20) DEFAULT NULL COMMENT '点赞数',
     *   `comment` int(20) DEFAULT NULL COMMENT '评论数',
     *   `state` varchar(1) DEFAULT NULL COMMENT '审核状态',
     *   `channelid` varchar(20) DEFAULT NULL COMMENT '所属频道',
     *   `url` varchar(100) DEFAULT NULL COMMENT 'URL',
     *   `type` varchar(1) DEFAULT NULL COMMENT '类型',
     */

    @Id
    private String id;

    private String columnid;
    private String userid;
    private String title;
    private String content;
    private String image;
    private java.util.Date createtime;
    private java.util.Date updatetime;
    private String ispublic;
    private String istop;
    private Integer visits;
    private Integer comment;
    private String state;
    private String channelid;
    private String url;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumnid() {
        return columnid;
    }

    public void setColumnid(String columnid) {
        this.columnid = columnid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
