package com.anand.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
    var yesno: RadioGroup? = null

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
        yesno = findViewById(R.id.yesno)
        check = findViewById(R.id.submit)


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
            } else if (college?.text.toString().trim().isNullOrEmpty()) {
                college?.error = "Field cannot be empty"
            } else if (contact?.text.toString().trim().isNullOrEmpty()) {
                contact?.error = "Field cannot be empty"
            }
                else if((contact?.text.toString().trim().get(0)?.toInt()?:0)<6){
                    contact?.error="Invalid Number"
            }

            else if (email?.text.toString().trim().isNullOrEmpty()) {
                email?.error = "Field cannot be empty"
            } else if (yesno?.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Select one Option Yes/No", Toast.LENGTH_SHORT).show()
            } else if (yes?.isChecked == true && study?.text.toString().isNullOrEmpty()) {
                study?.error = "Enter the study  field"
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("name", name?.text.toString().trim())
                intent.putExtra("contact_number", contact?.text.toString().trim())
                intent.putExtra("college_name",college?.text.toString().trim())
                intent.putExtra("mail",email?.text.toString().trim())
                intent.putExtra("study_field",study?.text.toString().trim())
                startActivity(intent)

            }


        }
    }
}





