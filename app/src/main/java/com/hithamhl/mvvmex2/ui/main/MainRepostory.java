package com.hithamhl.mvvmex2.ui.main;

import android.app.Application;
import android.app.ListActivity;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.hithamhl.mvvmex2.pojo.PostModel;
import com.hithamhl.mvvmex2.service.PostClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepostory {
    private static final String TAG = "MainRepostory";

    Application application;

    MutableLiveData<List<PostModel>> mutablePostData=new MutableLiveData<>();

    public MainRepostory(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<PostModel>> getPostData(){

        PostClient.getInstance().getAllPost().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                Log.d(TAG, "onResponse: "+response.message());

                if (response.isSuccessful()&&response.body()!=null){
                    mutablePostData.setValue(response.body());
                    PostRoomDBRepository dbRepository=new PostRoomDBRepository(application);
                    dbRepository.insertPosts(response.body());

                }

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });

        return mutablePostData;
    }
}
