package com.example.myintent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class ActivityForResult : AppCompatActivity() {
    companion object {
        const val RESULT_CODE = 312
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
    }

    private lateinit var btnChoose : Button
    private lateinit var rgNumber : RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener {
            if(rgNumber.checkedRadioButtonId != 0){
                val value = when(rgNumber.checkedRadioButtonId){
                    R.id.rb_10 -> 10
                    R.id.rb_20 -> 20
                    R.id.rb_30 -> 30
                    R.id.rb_100 -> 100
                    else -> 0
                }
                val intent = Intent()
                intent.putExtra(EXTRA_SELECTED_VALUE,value)
                setResult(RESULT_CODE,intent)
                finish()
            }
        }
    }
}
