package com.example.android.slider.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.slider.R

class HomeFragment4bestRateAdapter:RecyclerView.Adapter<HomeFragment4bestRateAdapter.HomeFragment4bestRateViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HomeFragment4bestRateViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.project4themostrate,parent,false)
        return HomeFragment4bestRateViewHolder(view)
    }

    override fun getItemCount(): Int {
      return 5
    }

    override fun onBindViewHolder(p0: HomeFragment4bestRateViewHolder, p1: Int) {

    }

    class HomeFragment4bestRateViewHolder(val view:View):RecyclerView.ViewHolder(view)
}