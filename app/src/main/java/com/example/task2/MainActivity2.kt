package com.example.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.task2.Data.dataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            fetchData(userId , title , body)
        }
    }
    fun fetchData(userId: String, title: String, body: String) {
        val data = dataModel(userId , title , body)
        val apiServie : ApiInterface = RetrofitClient.retrofit.create(ApiInterface::class.java)
        val call = apiServie.postData(data)
        call.enqueue(object : Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Log.d("userId is : " , userId)
                Log.d("title is : ", title)
                Log.d("body is ", body)
                Toast.makeText(applicationContext , "Submitted the Data" , Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext , MainActivity2::class.java)
                startActivity(intent)
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext , "Error Submitting data",Toast.LENGTH_LONG).show()
            }

        })
    }
}