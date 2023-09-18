package com.example.idmetaforatest.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.idmetaforatest.db.DataUser
import com.example.idmetaforatest.room.DbDao
import com.example.idmetaforatest.room.LIstTaskDao

class ListUserViewModel(context : Context) : ViewModel() {

    lateinit var user : LiveData<MutableList<DataUser>>
    private val database = DbDao.buildDb(context)
    var dao: LIstTaskDao = database.dao()

    init{

        user = dao.getDataProfil()
    }
}

class UserViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListUserViewModel::class.java)) {
            return ListUserViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}