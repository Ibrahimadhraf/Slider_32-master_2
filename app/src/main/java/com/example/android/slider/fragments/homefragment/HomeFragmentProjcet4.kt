package com.example.android.slider.fragments.homefragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.slider.R
import com.example.android.slider.adapter.Home4BestOffecersAdapter
import com.example.android.slider.adapter.HomeFragment4bestRateAdapter
import com.example.android.slider.adapter.Home_Projects4_DepartmentAdapter
import com.example.android.slider.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.homefragmentlproject4.*
import kotlinx.android.synthetic.main.homefragmentlproject4.view.*
import kotlinx.android.synthetic.main.homefragmentproject3.view.*
import java.util.*

class HomeFragmentProjcet4 :Fragment(){
    var currentPage:Int=0
    var  NUM_PAGES:Int=5
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.homefragmentlproject4,container,false)
      view.viewpager2.adapter=ViewPagerAdapter()
        view.indicator2.setViewPager(view.viewpager2)
        swipeViewPager()
        view.recyclerView2.adapter=Home_Projects4_DepartmentAdapter()
        view.recyclerView2.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,true))
        view.recyclerView3.adapter=HomeFragment4bestRateAdapter()
        view.recyclerView3.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,true))
        view.offers_recycle.adapter=Home4BestOffecersAdapter()
        view.offers_recycle.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,true))
        return view
    }
    fun swipeViewPager(){
        val handler = Handler()
        val update=Runnable(){
            if (currentPage == NUM_PAGES){
                currentPage=0
            }
            view!!.viewpager2.setCurrentItem(currentPage++,true)
        }
        val swipTimer= Timer()
        swipTimer.schedule( object : TimerTask(){
            override fun run() {
                handler.post(update)
            }
        }
            ,500,3000)



    }
}