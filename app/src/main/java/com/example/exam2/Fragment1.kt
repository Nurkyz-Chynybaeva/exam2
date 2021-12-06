package com.example.exam2

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var listener: OnButtonClicked
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<AppCompatEditText>(R.id.editName)
        val phone = view.findViewById<AppCompatEditText>(R.id.editPhone)
        val button = view.findViewById<AppCompatButton>(R.id.btnF1)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(requireContext())

        val adapter = Adapter {
            val text = it.name
            val number = it.phone
            listener.onClick(text, number)
        }
        button.setOnClickListener{
            if(name.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty()) {
                val cList = Data(name.text.toString(),phone.text.toString())
                adapter.setData(cList)
            }
        }
        recycler.layoutManager =layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))


    }
}