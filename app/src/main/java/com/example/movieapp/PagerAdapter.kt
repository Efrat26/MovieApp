package com.example.movieapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(
    manager: FragmentManager,
    val fragments: List<Fragment>
) : FragmentPagerAdapter(manager){

    override fun getItem(position: Int): Fragment =
        fragments[position]

    override fun getCount(): Int =
        fragments.size
}
