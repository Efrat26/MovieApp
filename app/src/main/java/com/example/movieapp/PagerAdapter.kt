package com.example.movieapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(
    manager: FragmentManager,
    val fragments: List<Fragment>
) : FragmentStatePagerAdapter(manager ){


    override fun getItem(position: Int): Fragment =
        fragments[position]

    override fun getCount(): Int =
        fragments.size
}
