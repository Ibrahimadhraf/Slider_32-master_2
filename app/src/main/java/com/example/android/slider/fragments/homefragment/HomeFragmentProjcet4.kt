package com.example.android.slider.fragments.homefragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
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
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.ui.settingviewmodel.SettingViewModel
import com.example.android.slider.ui.splash.SplashUi
import kotlinx.android.synthetic.main.homefragmentlproject4.*
import kotlinx.android.synthetic.main.homefragmentlproject4.view.*
import kotlinx.android.synthetic.main.homefragmentproject3.view.*
import java.util.*

class HomeFragmentProjcet4 :Fragment(){
    var settings_data: List<SettingsUseCase>? = null
    var currentPage:Int=0
    var  NUM_PAGES:Int=5
    lateinit var settingsViewModel: SettingViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.homefragmentlproject4,container,false)
        settingsViewModel= ViewModelProviders.of(this).get(SettingViewModel::class.java)
        settingsViewModel.getSettings()
        settingsViewModel.settingsResponse?.observe(this , android.arch.lifecycle.Observer {
            view.viewpager2.adapter=ViewPagerAdapter(it)
            view.indicator2.setViewPager(view.viewpager2)
            swipeViewPager()
        })

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