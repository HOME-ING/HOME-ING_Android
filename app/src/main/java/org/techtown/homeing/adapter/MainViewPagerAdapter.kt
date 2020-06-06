package org.techtown.homeing.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.homeing.R
import org.techtown.homeing.data.ViewPagerData
import org.techtown.homeing.viewholder.BannerVH

class MainViewPagerAdapter(private val context : Context) : RecyclerView.Adapter<BannerVH>(){

    val data = listOf<ViewPagerData>(ViewPagerData(),ViewPagerData(),ViewPagerData())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerVH {
        val view = LayoutInflater.from(context).inflate(R.layout.main_viewpager_item, parent, false)

        return BannerVH(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BannerVH, position: Int) {
    }
}