package com.example.labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.labs.adapter.RecyclerViewAdapter
import com.example.labs.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        parseArgs()
    }

    private fun parseArgs() {
        val test = intent.getStringExtra("test")
    }
}