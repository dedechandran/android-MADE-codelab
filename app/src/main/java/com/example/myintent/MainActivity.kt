package com.example.myintent

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 322
    }
    private lateinit var btnMoveActivity : Button
    private lateinit var btnMoveActivityData : Button
    private lateinit var btnMoveActivityDataObject : Button
    private lateinit var btnMoveDialUp : Button
    private lateinit var btnMoveActivityResult : Button
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivityData = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityDataObject = findViewById(R.id.btn_move_activity_object)
        btnMoveDialUp = findViewById(R.id.btn_move_dial)
        btnMoveActivityResult = findViewById(R.id.btn_move_activity_result)
        tvResult = findViewById(R.id.tv_result)

        //intent with no data
        btnMoveActivity.setOnClickListener {
            val intent = Intent(this,MoveActivity::class.java)
            startActivity(intent)
        }

        //intent with single data
        btnMoveActivityData.setOnClickListener {
            val intent = Intent(this,MoveActivityData::class.java)
            intent.putExtra(MoveActivityData.DATA_INTENT,"UHUYY")
            startActivity(intent)
        }

        //intent with data object
        btnMoveActivityDataObject.setOnClickListener {
            val intent = Intent(this,MoveActivityDataObject::class.java)
            val person = Person("Dede",20,"dedeskuy@skuy.com","Bandung")
            intent.putExtra(MoveActivityDataObject.EXTRA_PERSON,person)
            startActivity(intent)
        }

        //implisit intent (Dial Up)
        btnMoveDialUp.setOnClickListener {
            val phoneNumber = "0882223333444"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

        btnMoveActivityResult.setOnClickListener {
            val intent = Intent(this,ActivityForResult::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == ActivityForResult.RESULT_CODE){
                tvResult.text = data?.getIntExtra(ActivityForResult.EXTRA_SELECTED_VALUE,0).toString()
            }
        }
    }
}
