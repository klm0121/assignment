package com.example.assignment_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var flag : String = "1 digit"
        val gb : Button = findViewById(R.id.genbutton)
        val rslt : TextView = findViewById(R.id.textresult)
        val spin : Spinner = findViewById(R.id.spinner)
        var options = arrayOf("1 digit", "2 digit", "3 digit")
        spin.adapter = ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, options)
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        gb.setOnClickListener { view->
            var rand = (100..999).random()
            if(flag=="1 digit") rand=rand/100
            else if(flag=="2 digit") rand=rand/10
            rslt.text = rand.toString()
        }
    }
}

