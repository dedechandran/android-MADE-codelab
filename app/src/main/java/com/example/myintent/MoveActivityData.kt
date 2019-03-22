package com.example.myintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityData : AppCompatActivity() {
    companion object {
        const val DATA_INTENT = "data_intent"
    }

    private lateinit var tvDataIntent : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)
        tvDataIntent = findViewById(R.id.tv_data_intent)
        tvDataIntent.text = intent.getStringExtra(DATA_INTENT)
    }
}
