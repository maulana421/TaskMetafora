package com.example.idmetaforatest.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idmetaforatest.ViewModel.ListTaskViewModel
import com.example.idmetaforatest.ViewModel.TaskViewModelFactory
import com.example.idmetaforatest.adapter.ListTaskAdapter
import com.example.idmetaforatest.databinding.FragmentHomeBinding
import com.example.idmetaforatest.db.DbTask


class HomeFragment : Fragment() {



    private lateinit var binding : FragmentHomeBinding
    private lateinit var taskViewModel: ListTaskViewModel
    private lateinit var listTaskAdapter: ListTaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val viewModelFactory = TaskViewModelFactory(requireActivity())
        taskViewModel = ViewModelProvider(this,viewModelFactory)[ListTaskViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllData()
    }

    private fun getAllData(){
        taskViewModel.datas.observe(requireActivity()){
            setupRecycler(it.toMutableList())
            Toast.makeText(requireActivity(),"$it",Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecycler(data : MutableList<DbTask>){

        listTaskAdapter = ListTaskAdapter(data,object  : ListTaskAdapter.OnClick{})

        binding.task.apply {
            adapter = listTaskAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }

    }


}