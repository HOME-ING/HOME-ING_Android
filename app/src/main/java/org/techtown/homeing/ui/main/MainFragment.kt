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
            RankData( profile = "https://m.blog.naver.com/tarkyami/221878530592",name = "kangmin1012"),
            RankData(profile = "https://img.hankyung.com/photo/201903/01.19249613.1.jpg",name = "jooyae2"),
            RankData(profile = "https://cosmorning.com/data/photos/uploads/2018/03/%EC%9E%87%EC%B8%A0%EC%8A%A4%ED%82%A8-%EC%A0%84%EC%86%8D%EB%AA%A8%EB%8D%B8-%EA%B3%84%EC%95%BD_%ED%98%9C%EB%A6%AC.jpg",name = "blulemon")
        )

        rankAdp.notifyDataSetChanged()
    }

}
