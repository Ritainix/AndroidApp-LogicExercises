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

        Toast.makeText(this,"OnStart", Toast.LENGTH_SHORT).show()

        val buttonRS: Button =findViewById<Button>(R.id.MM_reverseString)
        val buttonF: Button =findViewById<Button>(R.id.MM_fibonacci)
        val buttonC: Button =findViewById<Button>(R.id.MM_coroutines)

        buttonRS.setOnClickListener {
            val intent = Intent(this, ReverseString::class.java)
            startActivity(intent)
        }

        buttonF.setOnClickListener {
            val intent = Intent(this, Fibonacci::class.java)
            startActivity(intent)
        }

        buttonC.setOnClickListener {
            val intent = Intent(this, excCoroutines::class.java)
            startActivity(intent)
        }
    }


    //activity life cycle to understand to understand each one
    override fun onStart(){
        super.onStart()
        Toast.makeText(this,"OnStart", Toast.LENGTH_SHORT).show()
    }

    override fun onPause(){
        super.onPause()
        Toast.makeText(this,"OnPause", Toast.LENGTH_SHORT).show()
    }

    override fun onResume(){
        super.onResume()
        Toast.makeText(this,"OnResume", Toast.LENGTH_SHORT).show()
    }

    override fun onStop(){
        super.onStop()
        Toast.makeText(this,"OnStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart(){
        super.onRestart()
        Toast.makeText(this,"OnRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy(){
        super.onDestroy()
        Toast.makeText(this,"OnDestroy", Toast.LENGTH_SHORT).show()
    }


}