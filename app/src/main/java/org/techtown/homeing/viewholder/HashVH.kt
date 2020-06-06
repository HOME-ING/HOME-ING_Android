package org.techtown.homeing.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.search_hashtag_item.view.*
import org.techtown.homeing.R
import org.techtown.homeing.data.HashData

class HashVH (view : View) : RecyclerView.ViewHolder(view){
    val title = view.findViewById<TextView>(R.id.hashtag_text)

    fun onBind(data : HashData){
        title.text = data.title
    }
}