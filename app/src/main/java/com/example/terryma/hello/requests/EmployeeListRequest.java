package com.example.terryma.hello.requests;

import com.example.terryma.hello.requests.base.PaginationRequest;

/**
 * Created by terryma on 16/12/9.
 */

public class EmployeeListRequest extends PaginationRequest {

    public EmployeeListRequest() {
    }

    public EmployeeListRequest(PaginationRequest request) {
        super(request);
    }

    private String[] ids;

    private String code;

    private String username;

    private String name;

    private Boolean disable;

    private String departmentId;

    private String positionId;

    private String lastAppKey;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastAppKey() {
        return lastAppKey;
    }

    public void setLastAppKey(String lastAppKey) {
        this.lastAppKey = lastAppKey;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }
}
