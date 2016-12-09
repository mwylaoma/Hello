package com.example.terryma.hello.requests.base;

/**
 * 排序请求对象
 * Created by terryma on 16/12/9.
 */
public class OrderByRequest {


    private String orderByField;

    private String orderByMethod = "ASC";

    private String orderByDbField;

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

    public String getOrderByMethod() {
        return orderByMethod;
    }

    public void setOrderByMethod(String orderByMethod) {
        this.orderByMethod = orderByMethod;
    }

    public String getOrderByDbField() {
        return orderByDbField;
    }

    public void setOrderByDbField(String orderByDbField) {
        this.orderByDbField = orderByDbField;
    }
}
