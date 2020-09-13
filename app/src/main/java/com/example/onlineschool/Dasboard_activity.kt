package com.example.onlineschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dasboard_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dasboard_activity)

        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/online-shcool.appspot.com/o/1.%20Activity%20Lifecycles.mp4?alt=media&token=616d763d-8e14-4dbd-891d-28e12c3de156"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/online-shcool.appspot.com/o/1.%20Modern%20Android%20App%20Architecture%20with%20Jetpack.mp4?alt=media&token=3bebb919-bd11-402e-bf5d-437bcbd1e134"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/online-shcool.appspot.com/o/1.%20What%20is%20the%20MVVM%20in%20Android.mp4?alt=media&token=c86de153-5641-4f25-b1a6-0b692d4b216b"
        var lesson4 = "https://firebasestorage.googleapis.com/v0/b/online-shcool.appspot.com/o/2.%20Build%20an%20Android%20App%20with%20ViewModel.mp4?alt=media&token=300305a9-c6d5-4555-8d94-8261f101dd94"

        var items = ArrayList<Lesson>()
        items.add(Lesson("Android development_1", "Activity lifecycles",lesson1))
        items.add(Lesson("Android development_2","Modern Android App Architecture",lesson2))
        items.add(Lesson("Android Development_3","What is hte MVVM in android",lesson3))
        items.add(Lesson("Android development_4","Build an Android app with viewModel",lesson4))

        val list:RecyclerView = findViewById<RecyclerView>(R.id.videos_list)

        val adapter = Adapter(items, applicationContext)

        list.layoutManager = GridLayoutManager(applicationContext,1)
        list.adapter = adapter
    }
}