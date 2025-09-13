package com.example.exercises

import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Collections.list

class Fibonacci : AppCompatActivity() {

    private lateinit var TextN1: EditText
    private lateinit var TextN2: EditText
    private lateinit var FSize: EditText
    private lateinit var ShowNumbers: TextView
    private lateinit var ButtonCreate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fibonacci)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        TextN1=findViewById<EditText>(R.id.InsertNumber1)
        TextN2=findViewById<EditText>(R.id.InsertNumber2)
        FSize=findViewById<EditText>(R.id.InsertSequence)
        ShowNumbers=findViewById<TextView>(R.id.ShowNumbers)
        ButtonCreate=findViewById<Button>(R.id.Create)

        ButtonCreate.setOnClickListener { fibonacci() }
    }

    fun fibonacci(){
        val n1=TextN1.text.toString().toInt()
        val n2=TextN2.text.toString().toInt()
        val s=FSize.text.toString().toInt()
        val numberList=mutableListOf<Int>(n1,n2)

        for (i in 2 until s){
            val nextNumber=numberList[numberList.size-1] + numberList[numberList.size-2]
            numberList.add(nextNumber)
        }
        ShowNumbers.text=numberList.joinToString ( ", ")

    }
}