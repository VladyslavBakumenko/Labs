package com.example.labs.rvAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.labs.databinding.RecyclerViewItemBinding
import com.example.labs.Application

class RecyclerViewViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val addProductClickListener: (entity: Application) -> Unit,
    private val removeProductClickListener: (cost: Int) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    private var selectedItems = 0

    fun onBind(entitie: Application) {
        with(binding) {
            root.setOnClickListener {
                addProductClickListener(entitie)
            }
            binding.tvEntityName.text = "App name = ${entitie.brand}"
            binding.tvEntityCost.text = "Target audience = ${entitie.screenSize}"
            binding.tvProductQuantity.text = "Visitors during the day = ${entitie.madeDate}"
            binding.tvEntityData.text = "Sell cost = ${entitie.model}"
        }
    }
}