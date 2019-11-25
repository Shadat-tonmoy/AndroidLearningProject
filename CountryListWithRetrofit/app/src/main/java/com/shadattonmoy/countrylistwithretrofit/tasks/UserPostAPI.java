package com.shadattonmoy.countrylistwithretrofit.tasks;

import com.shadattonmoy.countrylistwithretrofit.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserPostAPI
{

    @POST("posts")
    Call<User> getUserPostResult(@Body User user);
}
