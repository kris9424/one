package com.example.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Database
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    lateinit var editFragment: EditFragment
    lateinit var viewFragment: ViewFragment
    lateinit var database: PostDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editFragment = EditFragment.newInstance()
        viewFragment = ViewFragment.newInstance()
        database = Room.databaseBuilder(this, PostDatabase::class.java, "post")
            .build()
    }

    fun toView(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, viewFragment)
            .commit()
    }

    fun toEdit(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, editFragment)
            .commit()
    }
}