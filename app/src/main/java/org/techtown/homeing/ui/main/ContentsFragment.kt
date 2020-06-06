package org.techtown.homeing.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_contents.*
import kotlinx.android.synthetic.main.fragment_contents.view.*

import org.techtown.homeing.R
import org.techtown.homeing.adapter.HashAdapter
import org.techtown.homeing.data.HashData
import org.techtown.util.ItemDeco


class ContentsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_contents, container, false)

        initHash(v)

        return v
    }

    private fun initHash(v : View){
        var adapter = HashAdapter(v.context)
        v.search_hashtag_rcv.adapter = adapter
        v.search_hashtag_rcv.apply {
            layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(ItemDeco(v.context))
        }
        adapter.data = listOf(
            HashData("# 달고나 커피"),
            HashData("# 코하코토 만들기"),
            HashData("# 바나나컵 만들기")
        )

        adapter.notifyDataSetChanged()
    }

}
