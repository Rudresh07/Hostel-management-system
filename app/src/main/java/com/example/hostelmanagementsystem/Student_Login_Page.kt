package com.example.hostelmanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hostelmanagementsystem.databinding.ActivityStudentLoginPageBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Student_Login_Page : AppCompatActivity() {

    var binding:ActivityStudentLoginPageBinding? =null
    lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentLoginPageBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        binding?.login?.setOnClickListener {

            val Strollnumber = binding?.RollLogin?.text.toString()
            val Stpassword = binding?.Passwordlogin?.text.toString()

            if (Strollnumber.isEmpty() == true || Stpassword.isEmpty() ==true)
            {
                Toast.makeText(this, "please fill all credentials", Toast.LENGTH_SHORT).show()
            }

            else
            {
                checklogin(Strollnumber, Stpassword)
            }


        }

    }
    private fun checklogin(Rollnumber:String, Password:String) {

        dbRef = FirebaseDatabase.getInstance().getReference("Students")
        dbRef.child(Rollnumber).get().addOnSuccessListener {

            if (it.exists()){


                val password = it.child("password").value.toString()
                val username = it.child("username").value.toString()

                if (password == Password)
                {
                    val intent = Intent(this,Student_Section::class.java)
                    startActivity(intent)

                    finish()
                }

                else{
                    Toast.makeText(this, "Password mismatched", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "user not exist", Toast.LENGTH_SHORT).show()
            }


        }
    }
}
