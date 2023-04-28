package com.abschlussapp.majateichmann.luckyvstreamerlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.Streamer


class Adapter(
private val context: Context,
private val dataset: List<Streamer>
) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: StreamerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = StreamerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var streamer = dataset[position]
    }
}
