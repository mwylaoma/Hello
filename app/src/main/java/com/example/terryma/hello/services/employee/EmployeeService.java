package com.example.terryma.hello.services.employee;

import com.example.terryma.hello.requests.EmployeeListRequest;
import com.example.terryma.hello.response.base.Page;
import com.example.terryma.hello.response.employee.EmployeeBiz;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 员工Service
 * Created by terryma on 16/12/9.
 */

public interface EmployeeService {

    @POST("api/employee/list")
    Call<Page<EmployeeBiz>> list(@Body EmployeeListRequest employeeListRequest);
}
