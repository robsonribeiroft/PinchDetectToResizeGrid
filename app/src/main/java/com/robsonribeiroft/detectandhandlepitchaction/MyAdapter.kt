package com.robsonribeiroft.detectandhandlepitchaction

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robsonribeiroft.detectandhandlepitchaction.databinding.ItemPictureBinding

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var items = emptyList<PicturesModel>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(private val binding: ItemPictureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: PicturesModel) {
            binding.imageHolder.text = picture.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPictureBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}