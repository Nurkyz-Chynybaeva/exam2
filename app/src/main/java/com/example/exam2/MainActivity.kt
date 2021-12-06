package com.example.exam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnButtonClicked {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, Fragment1())
            .commit()
    }

    override fun onClick(value: String, number: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("txt", value)
        bundle.putString("num", number)
        fragment2.arguments = bundle
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}