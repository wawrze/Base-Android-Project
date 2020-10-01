package com.wawra.app_name.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wawra.app_name.database.daos.ModelDao
import com.wawra.app_name.database.entities.Model

@Database(
    entities = [Model::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun modelDao(): ModelDao

}