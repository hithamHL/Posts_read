package com.hithamhl.mvvmex2.pojo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_info")
data class PostModel(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: Int,
        @ColumnInfo(name = "body")
        var body: String,
        @ColumnInfo(name = "title")
        var title: String
)
