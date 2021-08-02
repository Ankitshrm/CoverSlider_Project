package com.insidecoderz.cyclicviewpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager

class MainActivity : AppCompatActivity() {
    internal var platformList:MutableList<Platform> = ArrayList()
    lateinit var pageViewer:HorizontalInfiniteCycleViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageViewer =findViewById(R.id.view_pager)

        init()
        val adapter=MyAdapter(this,platformList)
        pageViewer.adapter=adapter



    }

    private fun init()
    {
       platformList.add(Platform("",getString(R.string.linkedin),R.drawable.linkedin))
       platformList.add(Platform("",getString(R.string.fb),R.drawable.fb))
       platformList.add(Platform("",getString(R.string.instagram),R.drawable.ig))
       platformList.add(Platform("",getString(R.string.snap),R.drawable.snap))
    }
}