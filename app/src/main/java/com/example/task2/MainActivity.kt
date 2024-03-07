package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.Adapter.RecyclerViewAdapter
import com.example.task2.Data.dataClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(ArrayList())
        recyclerView.adapter = adapter
        fetchData()
    }
    fun fetchData(){
        val apiService : ApiInterface = RetrofitClient.retrofit.create(ApiInterface::class.java)
        val call : Call<List<dataClassItem>> = apiService.showData()

        call.enqueue(object : Callback<List<dataClassItem>>{
            override fun onResponse(
                call: Call<List<dataClassItem>>,
                response: Response<List<dataClassItem>>
            )
            {
                if(response.isSuccessful){
                    val dataModel : List<dataClassItem>? = response.body()

                    if(dataModel!= null){
                        val currentData = ArrayList(dataModel)
                        adapter.updateData(currentData)
                    }
                }
                else{
                    Toast.makeText(applicationContext,response.code(),Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<List<dataClassItem>>, t: Throwable) {
                Toast.makeText(applicationContext , "Error Loading data",Toast.LENGTH_LONG).show()
            }

        })
    }
}