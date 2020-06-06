package org.techtown.homeing.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager
import kotlinx.android.synthetic.main.fragment_contents.*
import kotlinx.android.synthetic.main.fragment_contents.view.*
import kotlinx.android.synthetic.main.fragment_contents.view.search_contents_rcv

import org.techtown.homeing.R
import org.techtown.homeing.adapter.GalAdapter
import org.techtown.homeing.adapter.HashAdapter
import org.techtown.homeing.data.HashData
import org.techtown.homeing.util.ItemDeco


class ContentsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_contents, container, false)

        initHash(v)
        initContents(v)

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

    private fun initContents(v : View){
        var contentsAdapter = GalAdapter(v.context)
        val manager = SpannedGridLayoutManager( orientation = SpannedGridLayoutManager.Orientation.VERTICAL, spans = 3)

        manager.spanSizeLookup = SpannedGridLayoutManager.SpanSizeLookup{ position ->
            if(position %12 == 0 || position%12 == 7){
                SpanSize(2,2)
            }
            else{
                SpanSize(1,1)
            }

        }

        v.search_contents_rcv.apply {
            adapter = contentsAdapter
            layoutManager = manager
        }
        // 통신 시작

    }

}
