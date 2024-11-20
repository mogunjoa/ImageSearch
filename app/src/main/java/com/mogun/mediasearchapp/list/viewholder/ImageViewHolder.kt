package com.mogun.mediasearchapp.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mogun.mediasearchapp.databinding.ItemImageBinding
import com.mogun.mediasearchapp.list.ItemHandler
import com.mogun.mediasearchapp.model.ImageItem
import com.mogun.mediasearchapp.model.ListItem

class ImageViewHolder(
    private val binding: ItemImageBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ListItem) {
        item as ImageItem
        binding.item = item
        binding.handler = itemHandler
    }
}