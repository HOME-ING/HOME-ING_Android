package org.techtown.homeing.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.search_contents_item.view.*
import org.techtown.homeing.R
import org.techtown.homeing.data.GalData

class GalVH (view : View) : RecyclerView.ViewHolder(view){

    val img = view.findViewById<ImageView>(R.id.contents_img)
    fun onBind(data : GalData.Data){
        Glide.with(itemView).load(data.challegeUrl).into(img)
    }
}