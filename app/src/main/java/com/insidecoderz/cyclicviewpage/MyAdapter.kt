package com.insidecoderz.cyclicviewpage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyAdapter (internal var context: Context,
                 internal var platformList:List<Platform>): PagerAdapter(){
    override fun getCount(): Int {
        return platformList.size
    }

    override fun isViewFromObject(view: View, p1: Any): Boolean {
        return view == p1
    }

    override fun destroyItem(container: ViewGroup, position: Int, p1: Any) {
        container.removeView(p1 as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false)
        val platform_image = view.findViewById<View>(R.id.option_image) as ImageView
        val platform_title = view.findViewById<View>(R.id.option_title) as TextView
        val platform_info = view.findViewById<View>(R.id.info) as TextView
        val btn_fav = view.findViewById<View>(R.id.btn_fav) as FloatingActionButton

        platform_image.setImageResource(platformList[position].image)
        platform_title.text=(platformList[position].name)
        platform_info.text=(platformList[position].info)


        btn_fav.setOnClickListener {
            Toast.makeText(context,"Saved",Toast.LENGTH_SHORT).show()

        }
        container.addView(view)
        return view
    }

}
