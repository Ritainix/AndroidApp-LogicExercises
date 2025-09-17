package com.example.exercises

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.*

class excCoroutines : AppCompatActivity() {

    private lateinit var ShowCoroutine: TextView
    private lateinit var StartButton: Button
    private val Coroutine1=CoroutineScope(Dispatchers.Main + Job())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exc_coroutines)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ShowCoroutine=findViewById<TextView>(R.id.TextCoroutine)
        StartButton=findViewById<Button>(R.id.Start)

        StartButton.setOnClickListener {
            startCoroutine()
        }
    }

    fun startCoroutine(){
        Coroutine1.launch {
            //before
            ShowCoroutine.text="Downloading..."
            delay(3000)
            //after
            ShowCoroutine.text="Hello World!"
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        Coroutine1.cancel()
        Toast.makeText(this,"Coroutine Destroyed", Toast.LENGTH_SHORT).show()
    }
}