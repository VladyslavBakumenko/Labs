package com.example.labs.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.labs.ProductData
import com.example.labs.databinding.RecyclerViewItemBinding

class RecyclerViewViewHolder(
    private val binding: RecyclerViewItemBinding,
    private val printerListener: (printer: String, cost: Int) -> Unit

) : RecyclerView.ViewHolder(binding.root) {

    private var selectedItems = 0

    fun onBind(productData: ProductData) {
        with(binding) {
            root.setOnClickListener {
                printerListener(productData.product, productData.cost)
            }
            tvProductName.text = productData.product
            tvProductCost.text = "Вартість = ${productData.cost}"
            if (selectedItems != 0) {
                selectedItems--
                tvProductQuantity.text = "Selected items count = $selectedItems"
            }
        }
    }
}
