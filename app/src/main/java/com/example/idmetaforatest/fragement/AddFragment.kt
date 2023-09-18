package com.example.idmetaforatest.fragement

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idmetaforatest.AddTaskActivity
import com.example.idmetaforatest.ViewModel.ListUserViewModel
import com.example.idmetaforatest.ViewModel.UserViewModelFactory
import com.example.idmetaforatest.adapter.ListUserAdapter
import com.example.idmetaforatest.databinding.FragmentAddBinding
import com.example.idmetaforatest.db.DataUser


class AddFragment : Fragment() {


    private lateinit var userViewModel: ListUserViewModel
    private lateinit var binding : FragmentAddBinding
    private lateinit var userAdapter : ListUserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(layoutInflater)


        val viewModelFactory = UserViewModelFactory(requireActivity())
        userViewModel = ViewModelProvider(this,viewModelFactory)[ListUserViewModel::class.java]
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData(){
        userViewModel.user.observe(requireActivity()){
            setupRecycler(it)
            Toast.makeText(requireActivity(), "$it", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecycler(data : MutableList<DataUser>){

        userAdapter = ListUserAdapter(data, object : ListUserAdapter.OnClick{
            override fun onClick(data: DataUser) {
                startActivity(Intent(requireActivity(),AddTaskActivity::class.java).also {
                    it.putExtra("data",data)
                })
            }

        })
        binding.user.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }


}