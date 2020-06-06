package org.techtown.homeing.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rank_item.view.*
import org.techtown.homeing.R
import org.techtown.homeing.data.RankData

class RankVH (view : View) : RecyclerView.ViewHolder(view){

    val name = view.findViewById<TextView>(R.id.ranking_name_txt)
    val profile= view.findViewById<ImageView>(R.id.rank_profile_img)

    fun onBind(data:RankData){
        name.text = data.name
        Glide.with(itemView).load(data.profile).error(R.drawable.login_img_illust).into(profile)
    }

}