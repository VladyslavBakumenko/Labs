package com.example.labs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.labs.databinding.ActivityMainBinding
import com.example.labs.rvAdapter.RecyclerViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var database: AppDatabase? = null
    private val scope = CoroutineScope(Dispatchers.IO)
    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.addNewTvButton.setOnClickListener {
            EntityArg.getInstance(null)
            val myIntent = Intent(this, AddEditApplicationActivity::class.java)
            this@MainActivity.startActivity(myIntent)
        }
        getAllEntities()
    }

    override fun onResume() {
        super.onResume()
        getAllEntities()
    }

    private fun getAllEntities() {
        scope.launch {
            if (database == null) {
                database = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "app_database"
                ).fallbackToDestructiveMigration().build()
            }
            if (recyclerViewAdapter == null) {
                initRecyclerView(database?.televisionDao()?.getAllTelevisions()!!)
            } else {
                recyclerViewAdapter?.submitList(database?.televisionDao()?.getAllTelevisions()!!)
            }
        }
    }

    private fun initRecyclerView(allTelevisions: List<Application>) {
        scope.launch(Dispatchers.Main) {
            recyclerViewAdapter = RecyclerViewAdapter({
                val myIntent = Intent(this@MainActivity, AddEditApplicationActivity::class.java)
                EntityArg.getInstance(it)
                this@MainActivity.startActivity(myIntent)
            }, {

            })

            with(binding.recyclerView) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = recyclerViewAdapter
            }
            recyclerViewAdapter?.submitList(allTelevisions)
            recyclerViewAdapter?.notifyDataSetChanged()
        }
    }
}