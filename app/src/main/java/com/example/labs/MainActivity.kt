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
    private var selectedProductsList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()
        binding.btnList.setOnClickListener {
            startSecondActivity()
        }
    }

    private fun initRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter({
            totalCost += it
            binding.tvTotalCost.text = "Total cost = $totalCost"
            addToList(it)
        }, {
            totalCost -= it
            binding.tvTotalCost.text = "Total cost = $totalCost"
            removeFromList(it)
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

    private fun removeFromList(cost: Int) {
        when (cost) {
            30 -> selectedProductsList.remove("Молоко")
            20 -> selectedProductsList.remove("Хліб")
            1 -> selectedProductsList.remove("Вода")
            40 -> selectedProductsList.remove("Сметана")
            5 -> selectedProductsList.remove("Картопля")
        }
    }

    private fun addToList(cost: Int) {
        when (cost) {
            30 -> selectedProductsList.add("Молоко")
            20 -> selectedProductsList.add("Хліб")
            1 -> selectedProductsList.add("Вода")
            40 -> selectedProductsList.add("Сметана")
            5 -> selectedProductsList.add("Картопля")
        }
    }

    private fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("test", selectedProductsList.toString())
        }
        startActivity(intent)
    }
}