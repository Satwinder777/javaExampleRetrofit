package com.shergill.mvvmjavaexample.repository;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shergill.mvvmjavaexample.interfase.ApiInterface;
import com.shergill.mvvmjavaexample.model.ApiResp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepository {

    ApiInterface api;
   private MutableLiveData<ApiResp> myapi1;

    public LiveData<ApiResp> apiResp ;
    public MyRepository(ApiInterface api){
       this.api = api;
    }
    public LiveData<ApiResp> loadData(){
        MutableLiveData<ApiResp> livedata= new MutableLiveData();
        api.getData1(3).enqueue(new Callback<ApiResp>() {
            @Override
            public void onResponse(Call<ApiResp> call, Response<ApiResp> response) {
                Log.e("MyRepo", "onsuccess: "+response.body().getData().getName() );
//                myapi1.setValue(response.body());
                livedata.setValue(response.body());

            }

            @Override
            public void onFailure(Call<ApiResp> call, Throwable t) {
                Log.e("MyRepo", "onerror: "+t.getMessage() );
            }
        });
        return livedata;
    }
}
