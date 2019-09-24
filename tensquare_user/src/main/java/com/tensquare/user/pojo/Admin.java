package com.tensquare.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {


    /**
     * `id` varchar(20) NOT NULL COMMENT 'ID',
     *   `loginname` varchar(100) DEFAULT NULL COMMENT '登陆名称',
     *   `password` varchar(100) DEFAULT NULL COMMENT '密码',
     *   `state` varchar(1) DEFAULT NULL COMMENT '状态',
     */
    @Id
    private String id;

    private String loginname;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
