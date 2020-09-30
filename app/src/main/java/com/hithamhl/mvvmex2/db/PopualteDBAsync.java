package com.hithamhl.mvvmex2.db;

import android.os.AsyncTask;

public class PopualteDBAsync extends AsyncTask<Void,Void,Void> {

    private final PostsDao postsDao;

    public PopualteDBAsync(PostInfoDataBase dataBase) {
        postsDao =dataBase.postsDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        postsDao.deleteAll();

        return null;
    }
}
