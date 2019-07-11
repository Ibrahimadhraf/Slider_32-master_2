package com.example.android.slider.fragments.homefragment

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.slider.MainActivity
import com.example.android.slider.adapter.*
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.ui.settingviewmodel.SettingViewModel
import kotlinx.android.synthetic.main.homefragmentlproject4.view.*
import java.util.*
import java.util.ResourceBundle.getBundle


class HomeFragmentProjcet4() :Fragment(){
    var currentPage:Int=0
    var  NUM_PAGES:Int=5
    lateinit var settingsViewModel: SettingViewModel
    lateinit var mAdapter: FamousProductAdapter
    var settings_data: List<SettingsUseCase>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(com.example.android.slider.R.layout.homefragmentlproject4,container,false)
        val bundle: Bundle? = getArguments()
      //   settings_data=bundle!!.getSerializable(MainActivity.SETTINGUSECASEkEY)as List<SettingsUseCase>
        settingsViewModel= ViewModelProviders.of(this).get(SettingViewModel::class.java)
        settingsViewModel.getSettings()
        settingsViewModel.settingsResponse?.observe(this , android.arch.lifecycle.Observer {
            mAdapter=FamousProductAdapter(it)
            view.viewpager_4.adapter=ViewPagerAdapter(it)
            view.indicator2.setViewPager(view.viewpager_4)

            swipeViewPager()

            view.departmentrecycler.adapter=Home_Projects4_DepartmentAdapter(it)

            if(it!!.get(3).departmentTemp== 1 ) {
                view.departmentrecycler.setLayoutManager(
                    LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        true
                    )
                )

            }
            if(it.get(3).departmentTemp== 2 ) {
                view.departmentrecycler.setLayoutManager(
                    LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        true
                    )
                )

            }
            if(it.get(3).departmentTemp== 3) {
                view.departmentrecycler.setLayoutManager(

                        GridLayoutManager(getContext(), 3)
                )
            }
            if(it.get(3).departmentTemp== 4) {
                view.departmentrecycler.setLayoutManager(

                    GridLayoutManager(getContext(),
                        2)
                )


            }

            view.recyclerView3.adapter=HomeFragment4bestRateAdapter(it)
            view.recyclerView3.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,true))

                val mLayoutManager = GridLayoutManager(activity, 2, LinearLayoutManager.HORIZONTAL, false)
                mLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        when (mAdapter.getItemViewType(position)) {
                            FamousProductAdapter.TYPE_FIRST_ITEM -> return 2
                            FamousProductAdapter.TYPE_ITEM -> return 1
                            else -> return -1
                        }
                    }
                }
            if(it.get(0).bestRateTemp==1) {
                view.offers_recycle.adapter = FamousProductAdapter(it)

                view.offers_recycle.setLayoutManager(mLayoutManager)
            }
           if(it.get(0).bestRateTemp==2) {
                view.offers_recycle.adapter=Home4BestOffecersAdapter()
                view.offers_recycle.setLayoutManager(
                    LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        true
                    )
                )
            }

        })




        return view
    }
    fun swipeViewPager(){
        val handler = Handler()
        val update=Runnable(){
            if (currentPage == NUM_PAGES){
                currentPage=0
            }
            view?.viewpager_4?.setCurrentItem(currentPage++)
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