package org.techtown.homeing.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.search_contents_item.view.*
import org.techtown.homeing.R
import org.techtown.homeing.data.GalData
import org.techtown.homeing.data.GalSData

class GalVH (view : View) : RecyclerView.ViewHolder(view){

    var img = view.findViewById<ImageView>(R.id.contents_img)

    fun onBind(data : GalSData){
        Glide.with(itemView).load(data.img).error(R.drawable.login_img_illust).into(img)
    }
}