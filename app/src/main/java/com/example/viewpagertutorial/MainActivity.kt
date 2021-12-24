package com.example.viewpagertutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagertutorial.adapter.ViewPager2Adapter
import com.example.viewpagertutorial.adapter.ViewPagerAdapter
import com.example.viewpagertutorial.anim.ZoomOutPageTransformer
import com.example.viewpagertutorial.menu.FavoriteFragment
import com.example.viewpagertutorial.menu.HomeFragment
import com.example.viewpagertutorial.menu.PersonFragment
import com.example.viewpagertutorial.menu.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var listFragment = mutableListOf(
        HomeFragment(),
        FavoriteFragment(),
        PersonFragment(),
        SettingFragment(),
        HomeFragment(),
        FavoriteFragment(),
        PersonFragment(),
        SettingFragment(),
        HomeFragment(),
        FavoriteFragment(),
        PersonFragment(),
        SettingFragment(),
        HomeFragment(),
        FavoriteFragment(),
        PersonFragment(),
        SettingFragment(),
        HomeFragment(),
        FavoriteFragment(),
        PersonFragment(),
        SettingFragment(),
        HomeFragment(),
        FavoriteFragment(),
        PersonFragment(),
        SettingFragment()

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mnHome ->
                    viewPager2.currentItem = 0
//                    viewPager.currentItem = 0
                R.id.mnFavorite ->
                    viewPager2.currentItem = 1
//                    viewPager.currentItem = 1
                R.id.mnPerson ->
                    viewPager2.currentItem = 2
//                    viewPager.currentItem = 2
                R.id.mnSetting ->
                    viewPager2.currentItem = 3
//                    viewPager.currentItem = 3
            }
            true
        }

        // view pager
//        setUpViewPager()

        // view pager 2
        setUpViewPager2()

    }

    private fun setUpViewPager() {
        viewPager.adapter = ViewPagerAdapter(
            listFragment,
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottomNavigationView.menu.findItem(R.id.mnHome).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.mnFavorite).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.mnPerson).isChecked = true
                    3 -> bottomNavigationView.menu.findItem(R.id.mnSetting).isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }

    private fun setUpViewPager2() {
//        viewPager2.adapter = ViewPager2Adapter(listFragment, this)
        val adapter2 = ViewPager2Adapter(
            listFragment,
            this,
            supportFragmentManager,
            this.lifecycle)
        viewPager2.adapter = adapter2

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        bottomNavigationView.menu.findItem(R.id.mnHome).isChecked = true

                    }
                    1 -> {
                        bottomNavigationView.menu.findItem(R.id.mnFavorite).isChecked = true

                    }
                    2 -> {
                        bottomNavigationView.menu.findItem(R.id.mnPerson).isChecked = true

                    }
                    3 -> {
                        bottomNavigationView.menu.findItem(R.id.mnSetting).isChecked = true

                    }
                }
            }
        })
        viewPager2.setPageTransformer(ZoomOutPageTransformer())

        viewPager2.offscreenPageLimit = 2

    }

    private fun getFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.viewPager, fragment)
            commit()
        }
    }

}