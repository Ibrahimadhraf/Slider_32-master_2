package com.example.android.slider.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.slider.R

class ProductType1Adapter:RecyclerView.Adapter<ProductType1Adapter.ProductType1ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ProductType1ViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.typelayout_product_1,parent,false)
        return ProductType1ViewHolder(view)
    }

    override fun getItemCount(): Int {
          return 5
    }

    override fun onBindViewHolder(p0: ProductType1ViewHolder, p1: Int) {
    }

    class ProductType1ViewHolder(val view: View): RecyclerView.ViewHolder(view){}
}