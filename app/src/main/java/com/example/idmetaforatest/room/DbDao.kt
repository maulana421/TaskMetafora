package com.example.idmetaforatest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.idmetaforatest.db.DataStatus
import com.example.idmetaforatest.db.DataTask
import com.example.idmetaforatest.db.DataUser

@Database(
    entities = [DataTask::class,DataUser::class,DataStatus::class],
    version = 3
)
abstract class DbDao : RoomDatabase(){

    abstract fun dao(): LIstTaskDao

    companion object {

        @Volatile
        private var instance: DbDao? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDb(context).also {
                instance = it
            }
        }

        fun buildDb(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DbDao::class.java,
            "ProgressTaskk"
        ).addCallback(RoomUser(context)).fallbackToDestructiveMigration().build()

    }

}