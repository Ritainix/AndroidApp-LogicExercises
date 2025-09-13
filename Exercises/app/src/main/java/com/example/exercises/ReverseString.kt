package com.example.exercises

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReverseString : AppCompatActivity() {

    private lateinit var getText: EditText
    private lateinit var showReverse: TextView
    private lateinit var buttonReverse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reverse_string)


        getText=findViewById<EditText>(R.id.InsertString)
        showReverse=findViewById<TextView>(R.id.TextReverse)
        buttonReverse=findViewById<Button>(R.id.Reverse)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonReverse.setOnClickListener {logicReverse() }
    }

    //Reverse a string using kotlin and logic

    private fun kotlinReverse() {
        val textString=getText.text.toString()
        showReverse.text=textString.reversed()
    }

    private fun logicReverse() {
        val textString=getText.text.toString()
        var textReversed=""

        for(i in textString.length-1 downTo 0){
            textReversed+=textString[i]
        }
        showReverse.text=textReversed
    }
}



