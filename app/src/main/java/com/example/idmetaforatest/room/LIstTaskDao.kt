package com.example.idmetaforatest.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idmetaforatest.db.DataStatus
import com.example.idmetaforatest.db.DbTask
import com.example.idmetaforatest.db.DataTask
import com.example.idmetaforatest.db.DataUser

@Dao
interface LIstTaskDao {


    @Query(
        "SELECT DataTask.*,nameTask, DataStatus.name_status AS status_name,DataUser.name_user AS user_name FROM DataTask " +
                "INNER JOIN DataUser ON DataTask.id_user = DataUser.id_user " +
                "INNER JOIN DataStatus ON DataTask.id_status_task = DataStatus.id_status_task"
    )
    fun getDataTaskUserAndProgress(): LiveData<List<DbTask>>


    @Query("SELECT * FROM DataTask")
    fun getDataAllTask():LiveData<List<DataTask>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataTask(data : DataTask)

    @Query("SELECT * FROM DataUser")
    fun getDataProfil(): LiveData<MutableList<DataUser>>

    @Query("SELECT * FROM DataStatus")
    fun getDataProgress(): LiveData<List<DataStatus>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataAllProfil(data : DataUser)

    @Insert
    suspend fun insertAllProgres(data : DataStatus)
}