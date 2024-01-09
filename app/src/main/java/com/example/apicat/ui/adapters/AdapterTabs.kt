package com.example.apicat.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.apicat.ui.fragments.FragmentInformation
import com.example.apicat.ui.fragments.FragmentStats


class AdapterTabs(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) FragmentInformation() else FragmentStats()
    }

}