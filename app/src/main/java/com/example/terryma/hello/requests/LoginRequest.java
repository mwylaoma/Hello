package com.example.terryma.hello.requests;

/**
 * Created by terryma on 16/12/3.
 */

public class LoginRequest {
    private String businessModuleCode;

    /**
     * 仓库编码，用于判断当前登陆用户是否拥有仓库权限（非必要，如果不存该参数，则不校验）
     */
    private String warehouseCode;

    /**
     * 帐户类型
     */
    private String accountType;

    /**
     * 帐户名称
     */
    private String username;

    /**
     * 帐户密码
     */
    private String password;

    public String getBusinessModuleCode() {
        return businessModuleCode;
    }

    public void setBusinessModuleCode(String businessModuleCode) {
        this.businessModuleCode = businessModuleCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
}
