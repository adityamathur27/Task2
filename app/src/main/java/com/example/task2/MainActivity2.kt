package com.example.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        var showApi : Button = findViewById(R.id.ShowApi)
        var submitResponse : Button = findViewById(R.id.SubmitResponse)

        showApi.setOnClickListener{
            val intent = Intent(applicationContext , MainActivity::class.java)
            startActivity(intent)
        }

        submitResponse.setOnClickListener{
            val userId : String = findViewById<EditText?>(R.id.userIdEdit).text.toString()
            val title : String= findViewById<EditText?>(R.id.titleuser).text.toString()
            val body : String= findViewById<EditText?>(R.id.bodyuser).text.toString()
            Log.d("userId is : " , userId)
            Log.d("title is : ", title)
            Log.d("body is ", body)
            Toast.makeText(applicationContext , "Submitted the Data" , Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext , MainActivity2::class.java)
            startActivity(intent)
        }


    }
}