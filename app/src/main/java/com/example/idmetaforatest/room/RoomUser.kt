package com.example.idmetaforatest.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.idmetaforatest.db.DataStatus
import com.example.idmetaforatest.db.DataUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomUser(private val context: Context) : RoomDatabase.Callback() {

override fun onCreate(db: SupportSQLiteDatabase) {
    super.onCreate(db)
    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
        val database = Room.databaseBuilder(context, DbDao::class.java, "ProgressTaskk").build()
        val userDao = database.dao()

        val profil1 = DataUser(0, "Maulana")
        val profil2 = DataUser(0, "Ibnu")
        val profil3 = DataUser(0, "Fajar")


        val progress1 = DataStatus(0, "Belum Dikerjakan")
        val progress2 = DataStatus(0, "Sedang Dikerjakan")
        val progress3 = DataStatus(0, "Sudah Dikerjakan")


        userDao.insertDataAllProfil(profil1)
        userDao.insertDataAllProfil(profil2)
        userDao.insertDataAllProfil(profil3)

        userDao.insertAllProgres(progress1)
        userDao.insertAllProgres(progress2)
        userDao.insertAllProgres(progress3)


        database.close()
    }
}

    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)

    }
}