package org.techtown.homeing.data

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.homeing.R
import org.techtown.homeing.viewholder.RankVH

class RankAdp (private val context : Context) : RecyclerView.Adapter<RankVH>(){
    var data = listOf<RankData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankVH {
        val view = LayoutInflater.from(context).inflate(R.layout.rank_item, parent, false)

        return RankVH(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RankVH, position: Int) {
        holder.onBind(data[position])
    }
}