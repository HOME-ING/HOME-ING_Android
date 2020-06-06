package org.techtown.homeing.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rank_item.view.*
import org.techtown.homeing.R
import org.techtown.homeing.data.RankData

class RankVH (view : View) : RecyclerView.ViewHolder(view){

    val name = view.findViewById<TextView>(R.id.ranking_name_txt)

    fun onBind(data:RankData){
        name.text = data.name
    }

}