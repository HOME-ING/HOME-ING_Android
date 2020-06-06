package org.techtown.homeing.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.homeing.R
import org.techtown.homeing.data.HashData
import org.techtown.homeing.viewholder.HashVH

class HashAdapter (private val context : Context) : RecyclerView.Adapter<HashVH>(){
    var data = listOf<HashData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HashVH {
        val view = LayoutInflater.from(context).inflate(R.layout.search_hashtag_item, parent, false)

        return HashVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HashVH, position: Int) {
        holder.onBind(data[position])
    }
}