package com.example.terryma.hello.services.login;

import com.example.terryma.hello.requests.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by terryma on 16/12/3.
 */

public interface LoginService {

    @POST("/api/security/login")
    Call<String> login(@Body LoginRequest loginRequest);
}
