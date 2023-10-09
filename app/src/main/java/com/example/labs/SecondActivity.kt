package com.example.labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.labs.adapter.RecyclerViewAdapter
import com.example.labs.databinding.ActivityMainBinding
import com.example.labs.databinding.SecondActivityBindingBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBindingBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        parseArgs()
    }

    private fun parseArgs() {
        binding.image.setImageResource(intent.getIntExtra("test", 0))
    }
}