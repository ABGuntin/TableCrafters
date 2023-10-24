package com.example.tablecrafters.services.interfaces;

import com.example.tablecrafters.models.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiLogin {
    @POST("/posts")
    @FormUrlEncoded
    Call<Login> savePost(@Field("email") String email,
                         @Field("password") String password);

    @GET("/gets")
    @FormUrlEncoded
    Call<Login> getData(@Field("email") String email,
                         @Field("password") String password);
}
