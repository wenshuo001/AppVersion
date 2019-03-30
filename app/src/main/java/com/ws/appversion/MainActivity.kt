package com.ws.appversion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.FrameLayout
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Pair
import android.util.TypedValue
import com.ws.appversion.activity.BaseActivity
import com.ws.appversion.frgment.AppVersionFragment
import com.ws.appversion.frgment.MyFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolBar(toolbar, false, "")
        initViewPager()
        setAppBarListener()
    }


    override fun translucentStatusBar(): Boolean {
        return true
    }

    fun initViewPager(){
//        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
//            val minScrollHeight = header.getMeasuredHeight()
//            var margin = minScrollHeight + verticalOffset
//            margin = if (margin > 0) 0 else margin
//            val layoutParams = sticky_view.getLayoutParams() as FrameLayout.LayoutParams
//            layoutParams.topMargin = margin
//            sticky_view.setLayoutParams(layoutParams)
//        })
    }

    val mFragmentList = mutableListOf<Pair<String, Fragment>>()

    fun setAppBarListener(){
        mFragmentList.add(Pair("快乐教师", AppVersionFragment()))
        mFragmentList.add(Pair("快乐校园", MyFragment()))
        vp.adapter= MainAdapter(supportFragmentManager)
        table_layout.setupWithViewPager(vp)
    }



    private inner class MainAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position).second
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentList.get(position).first
        }
    }
}


