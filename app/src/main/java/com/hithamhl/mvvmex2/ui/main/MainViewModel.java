package com.hithamhl.mvvmex2.ui.main;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hithamhl.mvvmex2.pojo.PostModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "MainViewModel";
    MainRepostory mainRepostory;
    PostRoomDBRepository postRoomDBRepository;
    MutableLiveData<List<PostModel>> mutablePostData;
    private LiveData<List<PostModel>> mAllPosts;


    public MainViewModel(Application application){
        super(application);

        mainRepostory=new MainRepostory(application);
        postRoomDBRepository=new PostRoomDBRepository(application);

        mutablePostData=mainRepostory.getPostData();
        mAllPosts=postRoomDBRepository.getmAllPosts();



    }

    LiveData<List<PostModel>> getPost(){
//        Log.d(TAG, "getPost: listSize: "+postRoomDBRepository.getmAllPosts().getValue().size());
       return mAllPosts;
    }

}
