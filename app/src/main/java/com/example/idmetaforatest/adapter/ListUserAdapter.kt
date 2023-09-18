package com.example.idmetaforatest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idmetaforatest.databinding.UserListBinding
import com.example.idmetaforatest.db.DataUser

class ListUserAdapter(private val datas : MutableList<DataUser>, private val listern : OnClick) :
    RecyclerView.Adapter<ListUserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: UserListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(UserListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int  = datas.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = datas[position].name_user
            card.setOnClickListener {
                listern.onClick(datas[position])
            }

        }
    }

    interface OnClick {
        fun onClick(data : DataUser)
    }
}