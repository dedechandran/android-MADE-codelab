package com.example.myintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityDataObject : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    private lateinit var tvPersonName : TextView
    private lateinit var tvPersonAge : TextView
    private lateinit var tvPersonEmail : TextView
    private lateinit var tvPersonCity : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data_object)

        tvPersonName = findViewById(R.id.tv_name)
        tvPersonAge = findViewById(R.id.tv_age)
        tvPersonEmail = findViewById(R.id.tv_email)
        tvPersonCity = findViewById(R.id.tv_city)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
        tvPersonName.text = person.name
        tvPersonAge.text = person.age.toString()
        tvPersonEmail.text = person.email
        tvPersonCity.text = person.city
    }
}
