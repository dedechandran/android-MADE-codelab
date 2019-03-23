package com.example.myfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val homeFragment = HomeFragment()

        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.simpleName)
        Log.d("FIRST FRAGMENT",fragment.toString())
        if(fragment !is HomeFragment){
            fragmentTransaction.add(R.id.fragment_container,homeFragment,HomeFragment::class.simpleName)
            fragmentTransaction.commit()
        }
    }
}
