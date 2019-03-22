package com.example.myactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var edtLength : EditText
    private lateinit var btnCalculate : Button
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_lebar)
        edtLength = findViewById(R.id.edt_panjang)
        edtHeight = findViewById(R.id.edt_tinggi)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyField = false
            var isInvalidDouble = false

            if(TextUtils.isEmpty(inputLength)){
                isEmptyField = true
                edtLength.error = "Field tidak boleh kosong"
            }
            if(TextUtils.isEmpty(inputWidth)){
                isEmptyField = true
                edtWidth.error = "Field tidak boleh kosong"
            }
            if(TextUtils.isEmpty(inputHeight)){
                isEmptyField = true
                edtHeight.error = "Field tidak boleh kosong"
            }

            val length = toDouble(inputLength)
            val width = toDouble(inputWidth)
            val height = toDouble(inputHeight)

            if(length == null){
                isInvalidDouble = true
                edtLength.error = "Value tidak valid"
            }
            if(width == null){
                isInvalidDouble = true
                edtWidth.error = "Value tidak valid"
            }
            if(height == null){
                isInvalidDouble = true
                edtHeight.error = "Value tidak valid"
            }

            if(!isEmptyField && !isInvalidDouble){
                if(length != null && width != null && height != null){
                    val volume = length*height*width
                    tvResult.text = volume.toString()
                }


            }
        }
        savedInstanceState?.getString(STATE_RESULT).let { tvResult.text = it }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(STATE_RESULT,tvResult.text.toString())
    }

    private fun toDouble(str : String) : Double?{
        return try {
            str.toDouble()
        }catch (e : NumberFormatException){
            null
        }
    }


}
