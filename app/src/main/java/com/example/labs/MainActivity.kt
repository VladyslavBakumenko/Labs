package com.example.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.example.labs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setClickListener()
    }

    private fun setClickListener() {
        binding.changeTextButton.setOnClickListener {
            binding.tv.text = "Текст було змінено"
            binding.root.background =  AppCompatResources.getDrawable(this, R.color.red)
        }
    }
}