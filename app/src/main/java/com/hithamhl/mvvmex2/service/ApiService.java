package com.hithamhl.mvvmex2.service;



import com.hithamhl.mvvmex2.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    Call<List<PostModel>> makeRequest();
}
