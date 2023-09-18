package com.example.idmetaforatest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idmetaforatest.databinding.ListTaskBinding
import com.example.idmetaforatest.db.DbTask

class ListTaskAdapter(
    private val datas : MutableList<DbTask>,
    private val listern : OnClick) : RecyclerView.Adapter<ListTaskAdapter.TaskViewHolder>() {
    inner class TaskViewHolder (val binding : ListTaskBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ListTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int  = datas.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.apply {
            tvnamaTask.text = datas[position].nameTask
            tvstatusTask.text = datas[position].status_name
            tvuserTask.text = datas[position].user_name
        }
    }


    interface OnClick {

    }
}