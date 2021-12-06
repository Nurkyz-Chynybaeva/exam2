package com.example.exam2

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment2) {
    private lateinit var listener: OnButtonClicked
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt1 = view.findViewById<AppCompatTextView>(R.id.txt1F2)
        val txt2 = view.findViewById<AppCompatTextView>(R.id.txt2F2)

        val textName = arguments?.getString("txt")
        val textNumber = arguments?.getString("num")

        txt1.text = textName
        txt2.text = textNumber.toString()
    }
}