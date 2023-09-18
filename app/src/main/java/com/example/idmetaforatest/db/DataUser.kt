package com.example.idmetaforatest.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class DataUser(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    val id_user : Int,

    @ColumnInfo(name = "name_user")
    val name_user : String

):Parcelable
