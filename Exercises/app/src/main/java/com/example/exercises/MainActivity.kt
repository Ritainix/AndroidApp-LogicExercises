package com.example.exercises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonRS: Button =findViewById<Button>(R.id.MM_reverseString)
        val buttonF: Button =findViewById<Button>(R.id.MM_fibonacci)

        buttonRS.setOnClickListener {
            val intent = Intent(this, ReverseString::class.java)
            startActivity(intent)
        }

        buttonF.setOnClickListener {
            val intent = Intent(this, Fibonacci::class.java)
            startActivity(intent)
        }
    }


}