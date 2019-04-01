package com.ws.appversion

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Pair
import android.view.Menu
import android.view.MenuItem
import com.ws.appversion.activity.BaseActivity
import com.ws.appversion.frgment.TeacherFragment
import com.ws.appversion.frgment.MyFragment
import com.ws.appversion.frgment.ParentFragment
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
        mFragmentList.add(Pair("快乐教师", TeacherFragment()))
        mFragmentList.add(Pair("快乐校园", ParentFragment()))
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }


    public var releaseOrdebug = 0  // 0 测试服 1 正式服

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.toolbar_user){ //正式服
            releaseOrdebug=1
        }else{
            releaseOrdebug=0
        }

        return super.onOptionsItemSelected(item)
    }
}


