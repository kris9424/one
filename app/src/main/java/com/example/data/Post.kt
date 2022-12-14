package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Post (
    @PrimaryKey(autoGenerate = true)
    val idn: Int = 0,
    val title: String,
    val bady: String
    )
