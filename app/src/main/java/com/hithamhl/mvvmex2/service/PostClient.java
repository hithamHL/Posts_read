package com.hithamhl.mvvmex2.service;

import com.hithamhl.mvvmex2.pojo.PostModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
   private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

   private ApiService apiService;
   private static PostClient INSTANCE;

   public static PostClient getInstance(){
       if (INSTANCE==null){

           INSTANCE=new PostClient();

       }

       return INSTANCE;
   }

   public PostClient(){
       Retrofit retrofit=new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .client(providersOkHttpClient())
               .build();

       apiService=retrofit.create(ApiService.class);
   }

/**
 share same connection best performs with single connection
 connectionTIMEOUT
 A connect timeout defines a time period in which our client should establish a connection with a target host.

 A read timeout is applied from the moment the connection between a client and a target host has been successfully established
 */
   private static OkHttpClient providersOkHttpClient(){
       OkHttpClient.Builder httpClient=new OkHttpClient.Builder();

       return httpClient.readTimeout(1200, TimeUnit.SECONDS)
               .connectTimeout(1200,TimeUnit.SECONDS).build();
   }



   ///data request call methods
    public Call<List<PostModel>> getAllPost(){

       return apiService.makeRequest();
    }

}
