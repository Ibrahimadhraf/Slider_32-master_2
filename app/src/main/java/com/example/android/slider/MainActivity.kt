package com.example.android.slider
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.example.android.slider.databinding.ActivityMainBinding
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.fragments.buygtagment.BuyFragment
import com.example.android.slider.fragments.homefragment.HomeFragmentProjcet4
import com.example.android.slider.fragments.homefragment.HomeFragmentProjct1
import com.example.android.slider.fragments.homefragment.HomeFragmentProject2
import com.example.android.slider.fragments.homefragment.HomeFragmentProject3
import com.example.android.slider.fragments.morefragment.MoreFragment
import com.example.android.slider.fragments.offersfragment.OffersFragment
import com.example.android.slider.ui.splash.SplashUi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable


class MainActivity : AppCompatActivity(),Serializable {

    var settings_data: List<SettingsUseCase>? = null
    val SETTINGUSECASEkEY:String = "Settings"
    var logo:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       buttomNavigationView.setOnNavigationItemSelectedListener ( listener)
        buttomNavigationView.setSelectedItemId(R.id.nav_home)

        val intent: Intent? = getIntent()
       settings_data = intent?.getSerializableExtra(SplashUi.SETTINGUSECASEkEY) as List<SettingsUseCase>
        print(settings_data)
        binding.settingusecase = settings_data
        binding.executePendingBindings()

    }
    //add navigation button
    private val listener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var selectFragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.nav_home -> selectFragment = HomeFragmentProjcet4()
                R.id.nav_buy -> selectFragment = BuyFragment()
                R.id.nav_more -> selectFragment = MoreFragment()
                R.id.nav_offers->selectFragment= OffersFragment()
            }
            assert(selectFragment != null)
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment,
                selectFragment!!
            ).commit()
            true
        }


}