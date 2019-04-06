package com.example.codelab_listview

import android.content.res.TypedArray
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private val heroes :MutableList<Hero> = mutableListOf()
    private val name : MutableList<String> = mutableListOf()
    private val descriptions : MutableList<String> = mutableListOf()
    private var images : TypedArray? = null
    private lateinit var heroAdapter : HeroAdapter
    private lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lv_heroes)

        name.addAll(resources.getStringArray(R.array.data_name))
        descriptions.addAll(resources.getStringArray(R.array.data_description))
        images = resources.obtainTypedArray(R.array.data_photo)


        for (i in name.indices){
            val hero = Hero(images?.getResourceId(i,-1),name[i],descriptions[i])
            heroes.add(i,hero)
        }

        Log.d("HEROES LENGTH ",heroes.size.toString())
        heroAdapter = HeroAdapter(this)
        heroAdapter.setData(heroes)
        listView.adapter = heroAdapter
    }
}
