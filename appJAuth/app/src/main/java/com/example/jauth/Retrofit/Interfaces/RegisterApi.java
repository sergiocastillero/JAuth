package com.example.jauth.Retrofit.Interfaces;

import com.example.jauth.Retrofit.Models.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RegisterApi {

    @POST("register/{user_id}/")
    //@FormUrlEncoded
    Call<Register> postRegister(@Body Register register, @Path("user_id") String userID);
            //@Field("user_id") String user_id,
            //@Field("password") String password);
}