package com.anand.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name: EditText? = null
    var college: EditText? = null
    var contact: EditText? = null
    var email: EditText? = null
    var check: Button? = null
    var yes: RadioButton? = null
    var no: RadioButton? = null
    var study: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name = findViewById(R.id.name)
        college = findViewById(R.id.college)
        contact = findViewById(R.id.contact)
        email = findViewById(R.id.email)
        yes = findViewById(R.id.yes)
        no = findViewById(R.id.no)
        study = findViewById(R.id.study)
        check = findViewById(R.id.submit)


        check?.setOnClickListener {
            Toast.makeText(this, "Information Submitted", Toast.LENGTH_LONG).show()

        }


        yes?.setOnClickListener { }
        yes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                study?.visibility = View.VISIBLE
            } else {
                study?.visibility = View.GONE
            }
        }
        check?.setOnClickListener {
            if (name?.text.toString().trim().isEmpty()) {
                name?.error = "Field cannot be empty"
            } else if(college?.text.toString().trim().isNullOrEmpty()) {
                college?.error="Field cannot be empty"
            } else if (contact?.text.toString().trim().isNullOrEmpty()) {
                contact?.error="Field cannot be empty"
            }
            else if (study?.text.toString().trim().isEmpty()) {
                study?.error = "Enter your study field"
            }
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }


        }
    }



