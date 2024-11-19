package com.mogun.mediasearchapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mogun.mediasearchapp.databinding.ItemImageBinding
import com.mogun.mediasearchapp.databinding.ItemVideoBinding
import com.mogun.mediasearchapp.list.viewholder.ImageViewHolder
import com.mogun.mediasearchapp.list.viewholder.VideoViewHolder
import com.mogun.mediasearchapp.model.ImageItem
import com.mogun.mediasearchapp.model.ListItem

class ListAdapter: ListAdapter<ListItem, RecyclerView.ViewHolder>(diffUtil) {

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position) is ImageItem) {
            IMAGE_TYPE
        } else {
            VIDEO_TYPE
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if(viewType == IMAGE_TYPE) {
            ImageViewHolder(ItemImageBinding.inflate(inflater, parent, false))
        } else {
            VideoViewHolder(ItemVideoBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        if(getItemViewType(position) == IMAGE_TYPE) {
            (holder as ImageViewHolder).bind(item)
        } else {
            (holder as VideoViewHolder).bind(item)
        }
    }

    companion object {
        private const val IMAGE_TYPE = 0
        private const val VIDEO_TYPE = 1

        val diffUtil = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(
                oldItem: ListItem,
                newItem: ListItem
            ) = oldItem.thumbnailUrl == newItem.thumbnailUrl

            override fun areContentsTheSame(
                oldItem: ListItem,
                newItem: ListItem
            ) = oldItem == newItem

        }
    }
}