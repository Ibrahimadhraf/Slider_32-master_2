package com.example.android.slider.fragments


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.res.ColorStateList
import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.graphics.Color
import android.os.Handler
import android.support.design.button.MaterialButton
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import java.util.*
import android.graphics.Typeface



@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView?, resource: String?) {
 Glide.with(imageView?.context!!).load(resource).into(imageView)
}
@BindingAdapter("android:backgroundColor")
fun ViewGroup.setBackground(backgroundColor: String) {

 val color: Int = try {
  Color.parseColor(backgroundColor)
 } catch (e: Exception) {
  Color.parseColor("$#background")
 }
 setBackgroundColor(color)
}



 class UserViewModel:ViewModel() {
  var viewPager:MutableLiveData<Int>?=null
init {
 viewPager= MutableLiveData()

}



}
