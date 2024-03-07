package com.example.task2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.task2.Data.dataClassItem
import com.example.task2.R

class RecyclerViewAdapter(var items : ArrayList<dataClassItem>) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentItem = items[position]
        holder.userID.text = currentItem.id.toString()
        holder.body.text = currentItem.body
        holder.title.text = currentItem.title
    }
    fun updateData(newData: ArrayList<dataClassItem>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
class Holder(itemView : View) :RecyclerView.ViewHolder(itemView){
    val userID : TextView = itemView.findViewById(R.id.userId)
    val title : TextView = itemView.findViewById(R.id.title)
    val body : TextView = itemView.findViewById(R.id.body)
}