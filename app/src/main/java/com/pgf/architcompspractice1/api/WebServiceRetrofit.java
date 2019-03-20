package com.pgf.architcompspractice1.api;

import com.pgf.architcompspractice1.api.model.ApiResponseUserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServiceRetrofit {

    @GET("users")
    Call<ApiResponseUserList> getUserList(
            @Query("page") Integer page
    );

}
