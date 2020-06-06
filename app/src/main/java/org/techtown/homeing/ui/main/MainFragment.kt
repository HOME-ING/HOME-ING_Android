package org.techtown.homeing.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

import org.techtown.homeing.R
import org.techtown.homeing.adapter.MainViewPagerAdapter
import org.techtown.homeing.data.RankAdp
import org.techtown.homeing.data.RankData
import org.techtown.homeing.util.ItemDeco


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_main, container, false)

        initBanner(v)
        initRank(v)

        return v
    }

    fun initBanner(v : View){
        var bannerAdp = MainViewPagerAdapter(v.context)
        v.main_vp.adapter = bannerAdp
        v.main_vp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    fun initRank(v : View){
        var rankAdp = RankAdp(v.context)
        v.main_ranking_rcv.adapter = rankAdp
        v.main_ranking_rcv.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL, false)
        v.main_ranking_rcv.addItemDecoration(ItemDeco(v.context,size = 30))
        rankAdp.data = listOf(
            RankData(name = "kangmin1012"),
            RankData(name = "jooyae2"),
            RankData(name = "blulemon")
        )

        rankAdp.notifyDataSetChanged()
    }

}
