package com.example.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AdapterPages : FragmentStatePagerAdapter {
    constructor(fm: FragmentManager) : super(fm)

    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        val value = position + 1
        return MyFragment.getInstance("page $value")
    }
}