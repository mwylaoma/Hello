package com.example.terryma.hello.response.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.terryma.hello.common.fastjson.DateTimeFormat;

import java.util.Date;

/**
 * Created by terryma on 16/12/9.
 */

public class EntityBase {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

    /**
     * 版本
     */
    private int version;

    /**
     * 创建时间
     */
    @JSONField(format = DateTimeFormat.DATE_TIME)
    private Date created;

    /**
     * 最后修改时间
     */
    @JSONField(format = DateTimeFormat.DATE_TIME)
    private Date modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
