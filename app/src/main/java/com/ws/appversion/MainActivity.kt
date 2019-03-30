package com.ws.appversion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.FrameLayout
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentPagerAdapter
import com.ws.appversion.frgment.MyFragment




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager()
        setAppBarListener()
    }

    fun initViewPager(){
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val minScrollHeight = header.getMeasuredHeight()
            var margin = minScrollHeight + verticalOffset
            margin = if (margin > 0) 0 else margin
            val layoutParams = sticky_view.getLayoutParams() as FrameLayout.LayoutParams
            layoutParams.topMargin = margin
            sticky_view.setLayoutParams(layoutParams)
        })
    }

    val mFragmentList: MutableList<Fragment> = mutableListOf(MyFragment(), MyFragment(), MyFragment())

    fun setAppBarListener(){
        vp.setAdapter(object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return mFragmentList[position]
            }

            override fun getCount(): Int {
                return mFragmentList.size
            }
        })

        table_layout.addTab(table_layout.newTab().setText("Tab1"))
        table_layout.addTab(table_layout.newTab().setText("Tab2"))
        table_layout.addTab(table_layout.newTab().setText("Tab3"))

        table_layout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(vp))
        vp.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(table_layout))
    }
}


