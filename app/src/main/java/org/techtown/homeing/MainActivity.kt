package org.techtown.homeing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.homeing.adapter.PageAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_viewpager.adapter = PageAdapter(supportFragmentManager)
        main_viewpager.offscreenPageLimit = 2

        main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                main_bottom_navigation.menu.getItem(position).isChecked = true
            }
        })



        main_bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_main -> main_viewpager.currentItem = 0

                R.id.menu_contents -> main_viewpager.currentItem = 1

                R.id.menu_add -> Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()

                R.id.menu_story -> main_viewpager.currentItem = 3

                R.id.menu_my_page -> main_viewpager.currentItem = 4


            }
            true
        }

        main_bottom_navigation.itemIconTintList = null
    }

}



