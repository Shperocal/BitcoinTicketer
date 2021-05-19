package com.example.bitcointicketer.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


private const val NUM_PAGES = 3

class ScreenSlidePagerAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount():Int = NUM_PAGES

    override fun getItem(position: Int): Fragment {
        return MainFragment.newInstance(position)

    }

}