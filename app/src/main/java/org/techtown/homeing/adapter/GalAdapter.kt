package org.techtown.homeing.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.homeing.R
import org.techtown.homeing.data.GalData
import org.techtown.homeing.data.GalSData
import org.techtown.homeing.viewholder.GalVH


class GalAdapter (private val context : Context) : RecyclerView.Adapter<GalVH>(){
    var data = listOf<GalSData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalVH {
        val view = LayoutInflater.from(context).inflate(R.layout.search_contents_item, parent, false)

        return GalVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GalVH, position: Int) {
        holder.onBind(data[position])
    }
}