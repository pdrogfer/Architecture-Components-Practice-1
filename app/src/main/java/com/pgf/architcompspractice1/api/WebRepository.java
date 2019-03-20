package com.pgf.architcompspractice1.api;

import android.util.Log;

import com.pgf.architcompspractice1.api.model.ApiResponseUserList;
import com.pgf.architcompspractice1.api.model.DataItem;
import com.pgf.architcompspractice1.model.User;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebRepository {

    private static final String TAG = "WebRepository";
    public static final String URL_BASE = "https://reqres.in/api/";

    private WebServiceRetrofit webServiceRetrofit;

    public WebRepository() {

        Retrofit retrofitInstance = new Retrofit
                .Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webServiceRetrofit = retrofitInstance.create(WebServiceRetrofit.class);
    }

    public LiveData<List<User>> getUserList() {

        final MutableLiveData<List<User>> data = new MutableLiveData<>();

        Integer page = 1;
        Call<ApiResponseUserList> userListCall = webServiceRetrofit.getUserList(page);
        userListCall.enqueue(new Callback<ApiResponseUserList>() {
                    @Override
                    public void onResponse(Call<ApiResponseUserList> call, Response<ApiResponseUserList> response) {
                        data.setValue(mapApiResponseUserListToListUser(response.body().getData()));
                    }

                    @Override
                    public void onFailure(Call<ApiResponseUserList> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                    }
                });
        return data;
    }

    // mappers
    private List<User> mapApiResponseUserListToListUser(List<DataItem> data) {
        List<User> userList = new ArrayList<>();
        for (DataItem dataItem : data) {
            userList.add(new User(
                    dataItem.getId(),
                    dataItem.getFirstName(),
                    dataItem.getLastName(),
                    dataItem.getAvatar()
            ));
        }
        return userList;
    }
}
