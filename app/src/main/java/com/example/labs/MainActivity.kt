package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labs.adapter.RecyclerViewAdapter
import com.example.labs.databinding.ActivityMainBinding
import java.lang.StringBuilder

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
            ProductData("Coca cola", 30, 4),
            ProductData("Sprite", 20, 4),
            ProductData("Fanta", 1, 4),
            ProductData("Mojo", 40, 4),
            ProductData("Mirinda", 5, 4)
        )
    }

    private fun removeFromList(cost: Int) {
        when (cost) {
            30 -> selectedProductsList.remove("Coca cola")
            20 -> selectedProductsList.remove("Sprite")
            1 -> selectedProductsList.remove("Fanta")
            40 -> selectedProductsList.remove("Mojo")
            5 -> selectedProductsList.remove("Mirinda")
        }
    }

    private fun addToList(cost: Int) {
        when (cost) {
            30 -> selectedProductsList.add("Coca cola")
            20 -> selectedProductsList.add("Sprite")
            1 -> selectedProductsList.add("Fanta")
            40 -> selectedProductsList.add("Mojo")
            5 -> selectedProductsList.add("Mirinda")
        }
    }

    private fun startSecondActivity() {

        val resultString = StringBuilder()
        var colaCounter = 0
        var spriteCounter = 0
        var fantaCounter = 0
        var mojoCounter = 0
        var mirindaCounter = 0
        for (i in selectedProductsList) {
            when (i) {
                "Coca cola" -> colaCounter++
                "Sprite" -> spriteCounter++
                "Fanta" -> fantaCounter++
                "Mojo" -> mojoCounter++
                "Mirinda" -> mirindaCounter++
            }
        }
        resultString.append("$colaCounter X Coca cola " +
                " $spriteCounter X Sprite" +
                " $fantaCounter X Fanta" +
                " $mojoCounter X Mojo" +
                " $mirindaCounter X Mirinda")
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("test", resultString.toString())
        }
        startActivity(intent)
    }
}