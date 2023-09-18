package com.example.idmetaforatest.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.idmetaforatest.R
import com.example.idmetaforatest.adapter.ViewPagerAdapter
import com.example.idmetaforatest.databinding.FragmentBaseBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class BaseFragment : Fragment() {

    private lateinit var binding : FragmentBaseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBaseBinding.inflate(layoutInflater)
        setViewPager()
        return binding.root
    }

    private fun setViewPager(){
        val fragmentList = arrayListOf(
            HomeFragment(),
            AddFragment()
        )
        val viewPagerAdapter = ViewPagerAdapter(fragmentList,childFragmentManager,lifecycle)
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.Tablayout,binding.viewPager){tab,position ->
            when(position){
                0 -> tab.text = "A"
                1 -> tab.text = "B"
            }
        }.attach()
    }

    private fun TabLayout.setTabWidthAsWrapContent(tabPosition: Int) {
        val layout = (this.getChildAt(0) as LinearLayout).getChildAt(tabPosition) as LinearLayout
        val layoutParams = layout.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 0f
        layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        layout.layoutParams = layoutParams
    }


}