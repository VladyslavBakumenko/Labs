package com.example.labs.rvAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.labs.databinding.RecyclerViewItemBinding
import com.example.labs.Application

class RecyclerViewAdapter(
    private val addProductClickListener: (entity: Application) -> Unit,
    private val removeProductClickListener: (cost: Int) -> Unit
) :
    ListAdapter<Application, RecyclerViewViewHolder>(RecyclerViewDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context))
        return RecyclerViewViewHolder(binding, addProductClickListener, removeProductClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        currentList[position].let {
            holder.onBind(it)
        }
    }
}