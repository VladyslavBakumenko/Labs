package com.example.labs.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.labs.ProductData
import com.example.labs.R
import com.example.labs.databinding.RecyclerViewItemBinding

class RecyclerViewViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val addProductClickListener: (cost: Int) -> Unit,
    private val removeProductClickListener: (cost: Int) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    private val context = binding.root.context

    private var selectedItems = 0

    fun onBind(productData: ProductData) {
        with(binding) {
            tvProductName.text = productData.product
            tvProductCost.text = "Cost = ${productData.cost}"
            ivMinus.setOnClickListener {
                if (selectedItems != 0) {
                    selectedItems--
                    tvProductQuantity.text = "Selected items count = $selectedItems"
                    removeProductClickListener(productData.cost)
                }
            }
            ivPlus.setOnClickListener {
                selectedItems++
                tvProductQuantity.text = "Selected items count = $selectedItems"
                addProductClickListener(productData.cost)
            }
        }
        setProductImage(productData)
    }


    private fun setProductImage(productData: ProductData) {
        when (productData.product) {
            "Coca cola" -> binding.productImage.setImageDrawable(context.getDrawable(R.drawable.first))
            "Sprite" -> binding.productImage.setImageDrawable(context.getDrawable(R.drawable.second))
            "Fanta" -> binding.productImage.setImageDrawable(context.getDrawable(R.drawable.thirdh))
            "Mojo" -> binding.productImage.setImageDrawable(context.getDrawable(R.drawable.fourth))
            "Mirinda" -> binding.productImage.setImageDrawable(context.getDrawable(R.drawable.fiveth))
        }
    }
}