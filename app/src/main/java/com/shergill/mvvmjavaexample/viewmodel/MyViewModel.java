package com.shergill.mvvmjavaexample.viewmodel;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shergill.mvvmjavaexample.model.ApiResp;
import com.shergill.mvvmjavaexample.repository.MyRepository;
import com.shergill.mvvmjavaexample.retrofit.RetrofitHelper;

public class MyViewModel extends ViewModel {

   private MyRepository repo = new MyRepository(new RetrofitHelper().getService());


    public MutableLiveData<ApiResp> liveresp  = new MutableLiveData<ApiResp>(); ;
    public LiveData<ApiResp> updateData(){
//        liveresp.setValue();

        return repo.loadData();
        // Update internal data and notify observers
    }
}
