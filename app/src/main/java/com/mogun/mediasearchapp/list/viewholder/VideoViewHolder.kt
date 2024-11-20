package com.mogun.mediasearchapp.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mogun.mediasearchapp.databinding.ItemVideoBinding
import com.mogun.mediasearchapp.list.ItemHandler
import com.mogun.mediasearchapp.model.ListItem
import com.mogun.mediasearchapp.model.VideoItem

class VideoViewHolder(
    private val binding: ItemVideoBinding,
    private val itemHandler: ItemHandler? = null
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
        binding.handler = itemHandler
    }
}