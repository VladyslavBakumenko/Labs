package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs.adapter.RecyclerViewAdapter
import com.example.labs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0
    private var selectedPlacesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
        binding.startOtherActivity.setOnClickListener {
            startSecondActivity()
        }
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter { state, placeName ->
            if (state) addToList(placeName)
            else removeFromList(placeName)
            binding.tvPlaces.text = selectedPlacesList.toString()
        }

        with(binding.rvProducts) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
        recyclerViewAdapter.submitList(createList())
    }

    private fun createList(): List<ProductData> {
        return listOf(
            ProductData("Морське Окo", 30, 4, R.drawable.first),
            ProductData("Хохоловска Долина", 20, 4, R.drawable.second),
            ProductData("Національний парк Словінські", 1, 4, R.drawable.thirdh),
            ProductData("Мазурські озера", 40, 4, R.drawable.fourth),
        )
    }

    private fun addToList(placeName: String) {
        selectedPlacesList.add(placeName)
    }

    private fun removeFromList(placeName: String) {
        selectedPlacesList.remove(placeName)
    }

    private fun startSecondActivity() {
        if (selectedPlacesList.isNotEmpty()) {
            val id = when (selectedPlacesList.first()) {
                "Морське Окo" -> R.drawable.first
                "Хохоловска Долина" -> R.drawable.second
                "Національний парк Словінські" -> R.drawable.thirdh
                "Мазурські озера" -> R.drawable.fourth
                else -> 4
            }
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("test", id)
            }
            startActivity(intent)
        }
    }
}