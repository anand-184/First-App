package com.anand.firstapp

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    var etname :EditText ?= null
    var enteredname=""
    var enterednumber=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etname=findViewById(R.id.etname)

        intent?.extras?.let {
            enteredname=it.getString("name")?:""
            enterednumber= it.getString("contact number")?:""
            System.out.println("key $enteredname $enterednumber ")
        }
        etname?.setText(enteredname)
    }
}