package com.abschlussapp.majateichmann.luckyvstreamerlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abschlussapp.majateichmann.luckyvstreamerlist.data.datamodels.Streamer

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class Adapter(
private val dataset: List<Streamer>
) : RecyclerView.Adapter<Adapter.ItemViewHolder>(){

    /**
     * der ViewHolder umfasst die View und stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

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
