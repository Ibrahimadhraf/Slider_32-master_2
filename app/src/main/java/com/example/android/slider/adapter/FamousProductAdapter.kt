package com.example.android.slider.adapter

import android.support.v7.widget.RecyclerView
import android.databinding.DataBindingUtil
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.slider.R
import com.example.android.slider.databinding.Home4bestoffersBinding
import com.example.android.slider.databinding.TypelayoutProduct1Binding
import com.example.android.slider.databinding.Typeproductlayout2Binding
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import kotlinx.android.synthetic.main.home4bestoffers.view.*







class FamousProductAdapter(val settings:List<SettingsUseCase>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }


    var TYPE_FIRST_ITEM = 0
    var TYPE_ITEM = 1
    var view :Int=2;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            if (viewType == TYPE_FIRST_ITEM) {
                view = R.layout.typelayout_product_1

                val binding: TypelayoutProduct1Binding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    view,
                    parent,
                    false
                )
                return BigViewHolder(binding)
            }

            if (viewType == TYPE_ITEM) {

                view = R.layout.typeproductlayout_2
            }
            val binding2: Typeproductlayout2Binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                view,
                parent,
                false
            )

            return NormalViewHolder(binding2)
        }


    override fun getItemCount(): Int {
        return 5

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_FIRST_ITEM;
        } else return TYPE_ITEM;
    }




    class NormalViewHolder( val binding1: Typeproductlayout2Binding) : RecyclerView.ViewHolder(binding1.root)

     class BigViewHolder( val binding2:  TypelayoutProduct1Binding) : RecyclerView.ViewHolder(binding2.root)

    companion object {

        val TYPE_FIRST_ITEM = 0
        val TYPE_ITEM = 1
    }
}