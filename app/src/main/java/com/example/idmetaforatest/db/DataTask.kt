package com.example.idmetaforatest.db

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(

    foreignKeys = [
        ForeignKey(
            entity = DataUser::class,
            parentColumns = ["id_user"],
            childColumns = ["id_user"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DataStatus::class,
            parentColumns = ["id_status_task"],
            childColumns = ["id_status_task"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("id_user"), Index("id_status_task")]
)
data class DataTask(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="idTaskList")
    val idTaskList : Int,

    @ColumnInfo(name = "nameTask")
    val nameTask : String?,

    @ColumnInfo(name = "id_user")
    val id_user : Int?,

    @ColumnInfo(name = "id_status_task")
    var id_status_task : Int?

):Parcelable
