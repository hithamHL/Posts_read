package com.hithamhl.mvvmex2.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.hithamhl.mvvmex2.pojo.PostModel;

import java.util.List;

@Dao
public interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PostModel postModel);

    @Query("SELECT * from post_info ORDER BY id ASC")
    LiveData<List<PostModel>> getAllPost();


    @Query("DELETE from post_info")
    void deleteAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPost(List<PostModel> postModels);

}
