package com.example.terryma.hello.response.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.terryma.hello.common.fastjson.DateTimeFormat;

import java.util.Date;

/**
 * Created by terryma on 16/12/9.
 */

public class EmployeeBiz extends Employee {

    private String  employeeAccountId;
    private String  departmentCode;
    private String  departmentName;
    private String  positionCode;
    private String  positionName;
    private String  username;
    private String  password;
    private boolean allowLogin;

    @JSONField(format = DateTimeFormat.DATE_TIME)
    private Date lastLoginTime;

    private String  lastLoginIp;
    private String  lastAppKey;
    private String  employeeId;
    private boolean needLogin;
    private boolean isAdmin;
    private boolean isSingleUser;

    public String getEmployeeAccountId() {
        return employeeAccountId;
    }

    public void setEmployeeAccountId(String employeeAccountId) {
        this.employeeAccountId = employeeAccountId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAllowLogin() {
        return allowLogin;
    }

    public void setAllowLogin(boolean allowLogin) {
        this.allowLogin = allowLogin;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastAppKey() {
        return lastAppKey;
    }

    public void setLastAppKey(String lastAppKey) {
        this.lastAppKey = lastAppKey;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public boolean getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsSingleUser() {
        return isSingleUser;
    }

    public void setIsSingleUser(boolean isSingleUser) {
        this.isSingleUser = isSingleUser;
    }
}
