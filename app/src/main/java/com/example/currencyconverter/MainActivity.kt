package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val editText:EditText=findViewById(R.id.edt1)
        val textView:TextView=findViewById(R.id.txt1)
        val Imageview:ImageView=findViewById(R.id.imageV)
        val butn:Button=findViewById(R.id.btn)

  butn.setOnClickListener(){

      val ammount=editText.text.toString().toInt()
      val dolleramount=80*ammount
      textView.text="Converted Amount in Doller is $dolleramount"

  }

    }
}