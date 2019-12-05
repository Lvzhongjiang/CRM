package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
public class Documentary {

    private static final long serialVersionUID = 1L;

    @TableId(value = "did", type = IdType.AUTO)
    private Integer did;

    private String docudate;

    private String docutheme;

    private String dname;

    private String content;

    private String accessory;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDocudate() {
        return docudate;
    }

    public void setDocudate(String docudate) {
        this.docudate = docudate;
    }

    public String getDocutheme() {
        return docutheme;
    }

    public void setDocutheme(String docutheme) {
        this.docutheme = docutheme;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }
}
