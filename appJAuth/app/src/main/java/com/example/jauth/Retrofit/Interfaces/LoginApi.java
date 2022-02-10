package com.example.jauth.Retrofit.Interfaces;

import com.example.jauth.Retrofit.Models.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LoginApi {

    @GET("login/{user_id}/{password}")
    public Call<Login> getLogin(
            @Path("user_id") String user_id,
            @Path("password") String password);

}
