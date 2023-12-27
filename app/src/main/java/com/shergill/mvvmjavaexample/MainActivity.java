package com.shergill.mvvmjavaexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shergill.mvvmjavaexample.interfase.ApiInterface;
import com.shergill.mvvmjavaexample.model.ApiResp;
import com.shergill.mvvmjavaexample.model.PostRequestData;
import com.shergill.mvvmjavaexample.model.ResponceUserApi;
import com.shergill.mvvmjavaexample.retrofit.RetrofitHelper;
import com.shergill.mvvmjavaexample.viewmodel.MyViewModel;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ApiInterface service;
    Button btn;
    EditText name,job;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        name = findViewById(R.id.name);
        job = findViewById(R.id.job);
        text = findViewById(R.id.txtresp);
        String baseUrl = "https://reqres.in/";

        service = new RetrofitHelper().getService();

        service.getData1(2).enqueue(new Callback<ApiResp>() {
            @Override
            public void onResponse(Call<ApiResp> call, Response<ApiResp> response) {

                Log.e("Satta123", "onResponse: responce>>"+response.body() );
                text.setText(response.body().data.name.toString());

            }

            @Override
            public void onFailure(Call<ApiResp> call, Throwable t) {
                Log.e("Satta123", "onResponse: responce>>"+t.getMessage() );
                text.setText(t.getMessage());

            }
        });
        MyViewModel viewModel = new MyViewModel();

//                viewModel.updateData();
        viewModel.updateData().observe(MainActivity.this, new Observer<ApiResp>() {
            @Override
            public void onChanged(ApiResp apiResp) {
                if (apiResp==null){
                    Log.e("SgergillSatta", "onClick: null" );

                }else{
                    Log.e("SgergillSatta", "onClick: "+apiResp.getData().id+">>"+apiResp.getData().name );
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callRejisterApi(name.getText().toString(),job.getText().toString());
                viewModel.updateData();
            }
        });
    }

    void callRejisterApi(String name,String job){
        service.postData(new PostRequestData(name,job)).enqueue(new Callback<ResponceUserApi>() {
            @Override
            public void onResponse(Call<ResponceUserApi> call, Response<ResponceUserApi> response) {
                Log.e("Satta123", "onResponse: "+response.body() );
                text.setText(response.body().getName().toString());
            }

            @Override
            public void onFailure(Call<ResponceUserApi> call, Throwable t) {
                Log.e("Satta123", "onResponse: "+t.getMessage() );
                text.setText(t.getMessage());
            }
        });
    }
}