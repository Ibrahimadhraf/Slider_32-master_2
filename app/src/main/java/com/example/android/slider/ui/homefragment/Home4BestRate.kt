package com.example.android.slider.ui.homefragment

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.slider.R
import com.example.android.slider.databinding.Project4themostrateBinding
import com.example.android.slider.databinding.TypelayoutProduct1Binding

class Home4BestRateAdapter:RecyclerView.Adapter<Home4BestRateAdapter.HomeFragment4bestRateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HomeFragment4bestRateViewHolder {
        val binding: Project4themostrateBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.project4themostrate,
            parent,
            false
        )
        return HomeFragment4bestRateViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(p0: HomeFragment4bestRateViewHolder, p1: Int) {
    }

    class HomeFragment4bestRateViewHolder(val view:Project4themostrateBinding): RecyclerView.ViewHolder(view.root)
}