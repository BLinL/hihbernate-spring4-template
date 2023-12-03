package xyz.orm.bliu.model;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "snipper")
public class Snipper implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "snipper_id")
    private long snipperId;

    @Column(name = "snipper_code")
    private String snipperCode;


    @Column(name = "snipper_desc")
    private String desc;


    @Column(name = "auth_id")
    private String authId;


    @Column(name = "create_time")
    private Date createTime;


    public long getSnipperId() {
        return snipperId;
    }

    public void setSnipperId(long snipperId) {
        this.snipperId = snipperId;
    }

    public String getSnipperCode() {
        return snipperCode;
    }

    public void setSnipperCode(String snipperCode) {
        this.snipperCode = snipperCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Snipper{" +
                "snipperId=" + snipperId +
                ", snipperCode='" + snipperCode + '\'' +
                ", desc='" + desc + '\'' +
                ", authId='" + authId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
