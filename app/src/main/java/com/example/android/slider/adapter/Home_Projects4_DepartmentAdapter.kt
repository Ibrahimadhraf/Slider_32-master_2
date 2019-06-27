package com.example.android.slider.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.slider.R

class Home_Projects4_DepartmentAdapter:RecyclerView.Adapter<Home_Projects4_DepartmentAdapter.Home_Projects4_DepatmentHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Home_Projects4_DepatmentHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.home_projcts4_department,parent,false)
        return Home_Projects4_DepatmentHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(p0: Home_Projects4_DepatmentHolder, p1: Int) {

    }

    class Home_Projects4_DepatmentHolder(val view: View):RecyclerView.ViewHolder(view){}
}