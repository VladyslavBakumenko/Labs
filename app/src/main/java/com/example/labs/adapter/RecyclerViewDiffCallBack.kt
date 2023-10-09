package com.example.labs.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.labs.ProductData

class RecyclerViewDiffCallBack : DiffUtil.ItemCallback<ProductData>() {
    override fun areItemsTheSame(oldItem: ProductData, newItem: ProductData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProductData, newItem: ProductData): Boolean {
        return oldItem == newItem
    }
}