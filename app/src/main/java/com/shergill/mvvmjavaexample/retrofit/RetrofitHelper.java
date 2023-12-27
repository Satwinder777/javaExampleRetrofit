package com.shergill.mvvmjavaexample.retrofit;

import com.shergill.mvvmjavaexample.interfase.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private String baseUrl = "https://reqres.in/";
   Retrofit retrofit = new Retrofit.Builder()
           .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build();
    //    ApiInterface service = retrofit.create<ApiInterface?>(ApiInterface:: class.java)


    public ApiInterface getService() {
        return retrofit.create(ApiInterface.class);
    }
}
