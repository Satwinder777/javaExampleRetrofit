package com.shergill.mvvmjavaexample.interfase;

import com.shergill.mvvmjavaexample.model.ApiResp;
import com.shergill.mvvmjavaexample.model.PostRequestData;
import com.shergill.mvvmjavaexample.model.ResponceUserApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("api/unknown/{uid}")
    Call<ApiResp> getData1(@Path("uid") int num);

    @POST("api/users")
    Call<ResponceUserApi> postData(@Body PostRequestData data);

}
