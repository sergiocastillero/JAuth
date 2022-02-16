package com.example.jauth.Retrofit.Interfaces;

import com.example.jauth.Retrofit.Models.Register;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApi {

    @POST("register/{user_id}/{password}")
    //@FormUrlEncoded
    Call<Register> postRegister(@Body Register register);
            //@Field("user_id") String user_id,
            //@Field("password") String password);
}