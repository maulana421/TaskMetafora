package com.example.idmetaforatest.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataStatus(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name= "id_status_task")
    val idStatusTask : Int,

    @ColumnInfo(name = "name_status")
    val nameStatus : String?,
)
