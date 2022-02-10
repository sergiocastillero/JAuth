package com.example.jauth.Retrofit.Interfaces;

import com.example.jauth.Retrofit.Models.CheckIn;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CheckInApi {

    @POST("checkin/{user_id}")
    @FormUrlEncoded
    Call<CheckIn> postCheckIn(
            @Field("user_id") String user_id);

}
