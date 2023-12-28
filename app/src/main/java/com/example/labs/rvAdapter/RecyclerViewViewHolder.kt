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
            binding.tvEntityName.text = "Назва телефону -> ${entitie.brand}"
            binding.tvEntityCost.text = "Дата виходу телефона -> ${entitie.screenSize}"
            binding.tvProductQuantity.text = "Об'єм ОЗУ -> ${entitie.madeDate}"
            binding.tvEntityData.text = "Процесор -> ${entitie.model}"
        }
    }
}