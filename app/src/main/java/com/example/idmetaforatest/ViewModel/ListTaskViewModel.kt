package com.example.idmetaforatest.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.idmetaforatest.db.DataStatus
import com.example.idmetaforatest.db.DataTask
import com.example.idmetaforatest.db.DbTask
import com.example.idmetaforatest.room.DbDao
import com.example.idmetaforatest.room.LIstTaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListTaskViewModel(context : Context) : ViewModel() {

var datas : LiveData<List<DbTask>>
    lateinit var listTask : LiveData<List<DataTask>>
    lateinit var progress : LiveData<List<DataStatus>>

    private val database = DbDao.buildDb(context)
    var dao: LIstTaskDao = database.dao()

    init{

        datas = dao.getDataTaskUserAndProgress()
        listTask = dao.getDataAllTask()
        progress = dao.getDataProgress()

        Log.d("PP","${dao.getDataTaskUserAndProgress()}")
    }

    fun addTask(task : String,resultDropDown : String,idProfil : Int){
        viewModelScope.launch(Dispatchers.IO){
            val idProgressTask = when (resultDropDown) {
                "Belum Dikerjakan" -> 1
                "Sedang Dikerjakan" -> 2
                else -> 3
            }

            val modeTask = DataTask(
                idTaskList = 0,
                nameTask = task,
                id_user = idProfil,
                id_status_task = idProgressTask
            )
            dao.insertDataTask(modeTask)

        }
    }

}

class TaskViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListTaskViewModel::class.java)) {
            return ListTaskViewModel(context) as T
        }
        throw IllegalArgumentException("ViewModel tidak diketahui")
    }
}