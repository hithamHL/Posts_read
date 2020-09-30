package com.hithamhl.mvvmex2.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.hithamhl.mvvmex2.pojo.PostModel;

import kotlin.jvm.Synchronized;

@Database(entities = {PostModel.class},version = 1)
public abstract class PostInfoDataBase extends RoomDatabase {



    public abstract PostsDao postsDao();

    private static PostInfoDataBase INSTANCE;

   public static PostInfoDataBase getDataBase(Context context){
        if (INSTANCE==null){

            synchronized (PostInfoDataBase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            PostInfoDataBase.class,
                            "postinfo_database")
                            .addCallback(mRoomDataBase)
                            .build();
                }
            }

        }

        return INSTANCE;
    }
    private static Callback mRoomDataBase= new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

           // new PopualteDBAsync(INSTANCE).execute();
        }
    };



}
