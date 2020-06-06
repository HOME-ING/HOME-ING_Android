package org.techtown.homeing.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager
import kotlinx.android.synthetic.main.fragment_contents.*
import kotlinx.android.synthetic.main.fragment_contents.view.*
import kotlinx.android.synthetic.main.fragment_contents.view.search_contents_rcv

import org.techtown.homeing.R
import org.techtown.homeing.adapter.GalAdapter
import org.techtown.homeing.adapter.HashAdapter
import org.techtown.homeing.api.ContentsServiceImpl
import org.techtown.homeing.data.GalSData
import org.techtown.homeing.data.HashData
import org.techtown.homeing.util.ItemDeco
import org.techtown.homeing.util.customEnqueue


class ContentsFragment : Fragment() {

    private val mRequest : ContentsServiceImpl = ContentsServiceImpl
    private lateinit var contentsAdapter :GalAdapter

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
        contentsAdapter = GalAdapter(v.context)
        val manager = SpannedGridLayoutManager( orientation = SpannedGridLayoutManager.Orientation.VERTICAL, spans = 3)

        manager.spanSizeLookup = SpannedGridLayoutManager.SpanSizeLookup{ position ->
            if(position %12 == 0 || position%12 == 7){
                SpanSize(2,2)
            }
            else{
                SpanSize(1,1)
            }

        }


        v.search_contents_rcv.adapter = contentsAdapter
        v.search_contents_rcv.layoutManager = manager
        // 통신 시작

//        mRequest.service.getContents().customEnqueue(
//            onError = {Log.d("Call Fail","Fail")},
//            onSuccess = {
//                contentsAdapter.data = it.data
//                Log.d("Call Success","${contentsAdapter.data}")
//            }
//        )
        contentsAdapter.data = listOf(
            GalSData("https://res.heraldm.com/phpwas/restmb_idxmake.php?idx=507&simg=/content/image/2020/04/14/20200414000131_0.jpg"),
            GalSData("https://mblogthumb-phinf.pstatic.net/MjAyMDAzMDFfMTAz/MDAxNTgzMDM3NjY0MDMw.jgKTH5UsqElstPH1Tlf8jCchKxZj3maXIFZJIl6SKpMg.1XrHXP2jnn8uYjwhi1F2ULUOe9ICbp_M9WLduG1IUCQg.JPEG.ijarang1/1583037663670.jpg?type=w800"),
            GalSData("https://i.ytimg.com/vi/Nt6552VcgTM/maxresdefault.jpg"),
            GalSData("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSZLyFzT5N7x2Tn5wAsJdrqK81hQTx4JCdly_Mv_qqmxFsbBOB7&usqp=CAU"),
            GalSData("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQH38EUkkf4ciH3PwEhVMyBL24QziSoUf2bJpmgbaGQyV0vwqQ_&usqp=CAU"),
            GalSData("https://t2.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/2xMI/image/qFGxbyizMcx1_yQdQT5MMYhMrC0.png"),
            GalSData("https://m1.daumcdn.net/cfile246/image/99235C345E3817BB2C9BC4"),
            GalSData("https://t2.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/2xMI/image/qFGxbyizMcx1_yQdQT5MMYhMrC0.png"),
            GalSData("https://recipe1.ezmember.co.kr/cache/recipe/2019/02/03/7b702e54f4cd46ba0d0ff532eac8f09d1.jpg"),
            GalSData("https://t1.daumcdn.net/liveboard/cemmarketing/38e5eff26a8f43368f39d0f42f6cc78b.JPG"),
            GalSData("https://storage.googleapis.com/planet4-korea-stateless/2020/03/4909aaa0-%EB%A7%88%EC%8A%A4%ED%81%AC%EB%A7%8C%EB%93%A4%EA%B8%B0_01-300x225.jpg"),
            GalSData("https://storage.googleapis.com/planet4-korea-stateless/2020/03/288ed547-%EB%A7%88%EC%8A%A4%ED%81%AC%EB%A7%8C%EB%93%A4%EA%B8%B009-300x225.jpg"),
            GalSData("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS9g9irhLSrAaBXza2KPoYKNF6WgkNlDJrdfpPV_AvNlPmniYGC&usqp=CAU")

        )

        contentsAdapter.notifyDataSetChanged()



    }

}
