package com.example.idmetaforatest.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class DbTask(
    val idTaskList: Int,
    val nameTask: String?,
    val user_name: String?,
    val status_name: String?
):Parcelable
