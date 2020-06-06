package org.techtown.homeing.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import org.techtown.homeing.ui.main.ContentsFragment
import org.techtown.homeing.ui.main.MainFragment
import org.techtown.homeing.ui.main.MyPageFragment
import org.techtown.homeing.ui.main.StoryFragment


class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MainFragment()
            1 -> ContentsFragment()
            2 -> ContentsFragment()
            3 -> StoryFragment()
            4 -> MyPageFragment()
            else -> MyPageFragment()
        }
    }

    override fun getCount(): Int = 5
}