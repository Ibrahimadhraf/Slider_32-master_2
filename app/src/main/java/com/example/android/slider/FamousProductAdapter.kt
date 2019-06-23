package com.example.android.slider

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FamousProductAdapter: RecyclerView.Adapter<FamousProductAdapter.Famous_ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Famous_ProductViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.famous_productview,parent,false)
        return Famous_ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: Famous_ProductViewHolder, position: Int) {

    }

    class Famous_ProductViewHolder(val view: View): RecyclerView.ViewHolder(view){

    }
}