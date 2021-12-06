package com.example.exam2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val click: (data: Data) -> Unit)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var listData = mutableListOf<Data>()

    fun setData(data: Data) {
        listData.add(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(viewItem, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacts = listData[position]
        holder.bind(contacts)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(viewItem: View, private val click: (data: Data) -> Unit) :
        RecyclerView.ViewHolder(viewItem) {
        fun bind(contacts: Data) {

            val txt = itemView.findViewById<AppCompatTextView>(R.id.txtItem)
            val btn = itemView.findViewById<AppCompatButton>(R.id.btnItem)

            txt.text = contacts.name
            btn.setOnClickListener {
                click.invoke(contacts)
            }
        }
    }
}