package com.example.viewpagertutorial.adapter

import android.os.Bundle
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagertutorial.menu.FavoriteFragment
import com.example.viewpagertutorial.menu.HomeFragment
import com.example.viewpagertutorial.menu.PersonFragment
import androidx.viewpager.widget.PagerAdapter.POSITION_NONE




class ViewPager2Adapter(
    private val listFragment: MutableList<Fragment>,
    fragmentActivity: FragmentActivity,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]

    }

}