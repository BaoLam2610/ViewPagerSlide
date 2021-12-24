package com.example.viewpagertutorial.adapter

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagertutorial.menu.FavoriteFragment
import com.example.viewpagertutorial.menu.HomeFragment
import com.example.viewpagertutorial.menu.PersonFragment

class ViewPagerAdapter(
    var listFragment: List<Fragment>,
        fragmentManager: FragmentManager,
        behavior: Int
) : FragmentStatePagerAdapter(fragmentManager,behavior) {
    override fun getCount(): Int = listFragment.size

    override fun getItem(position: Int): Fragment = listFragment[position]
}