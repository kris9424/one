package com.example.data

import androidx.room.Insert
import androidx.room.Query

@androidx.room.Dao
interface Dao{
    @Query("SELECT * FROM Post")
    fun getPost(): List<Post>
    @Insert
    fun insertPost(post: Post)

}