package com.example.idmetaforatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.idmetaforatest.databinding.ActivityMainBinding
import com.example.idmetaforatest.fragement.BaseFragment
import com.example.idmetaforatest.fragement.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment(BaseFragment())
    }

    private fun setFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.container,fragment)
            commit()
        }
    }
}