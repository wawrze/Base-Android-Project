package com.wawra.app_name.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wawra.app_name.database.entities.Model
import io.reactivex.Single

@Dao
interface ModelDao {

    @Insert
    fun insert(model: Model): Single<Long>

    @Query("DELETE FROM model")
    fun deleteAll(): Single<Int>

    @Query("SELECT * FROM model")
    fun getAll(): Single<List<Model>>

}