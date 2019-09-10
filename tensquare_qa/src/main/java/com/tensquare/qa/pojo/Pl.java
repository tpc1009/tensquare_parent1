package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {

    /**
     * `problemid` varchar(20) NOT NULL COMMENT '问题ID',
     *   `labelid` varchar(20) NOT NULL COMMENT '标签ID',
     */
    @Id
    private String problemid;

    @Id
    private String labelid;

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }
}
