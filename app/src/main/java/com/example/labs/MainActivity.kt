package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs.adapter.RecyclerViewAdapter
import com.example.labs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var totalCost = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
//        binding.btnList.setOnClickListener {
//            startSecondActivity()
//        }
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter({
            totalCost += it
            binding.tvTotalCost.text = "Total cost = $totalCost"
        }, {
            totalCost -= it
            binding.tvTotalCost.text = "Total cost = $totalCost"
        })

        with(binding.rvProducts) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
        recyclerViewAdapter.submitList(createList())
    }

    private fun createList(): List<ProductData> {
        return listOf(
            ProductData("Молоко", 30, 4),
            ProductData("Хліб", 20, 4),
            ProductData("Вода", 1, 4),
            ProductData("Сметана", 40, 4),
            ProductData("Картопля", 5, 4)
        )
    }

    private fun startSecondActivity() {
    }
}