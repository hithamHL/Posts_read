package com.hithamhl.mvvmex2.ui.main;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.hithamhl.mvvmex2.db.PostInfoDataBase;
import com.hithamhl.mvvmex2.db.PostsDao;
import com.hithamhl.mvvmex2.pojo.PostModel;

import java.util.List;

public class PostRoomDBRepository {

    private PostsDao postsDao;
    LiveData<List<PostModel>> mAllPosts;

    public PostRoomDBRepository(Application application) {

        PostInfoDataBase dataBase=PostInfoDataBase.getDataBase(application);
        postsDao=dataBase.postsDao();
        mAllPosts=postsDao.getAllPost();

    }

    public LiveData<List<PostModel>> getmAllPosts(){
        return mAllPosts;
    }

    public void insertPosts(List<PostModel> postModelList){

        new insertDataAsync(postsDao).execute(postModelList);

    }

    private static class insertDataAsync extends AsyncTask<List<PostModel>,Void,Void>{
        private PostsDao postsDao;

       public insertDataAsync(PostsDao postsDao){
           this.postsDao=postsDao;
       }


        @Override
        protected Void doInBackground(List<PostModel>... lists) {
           postsDao.insertPost(lists[0]);
            return null;
        }
    }

}
