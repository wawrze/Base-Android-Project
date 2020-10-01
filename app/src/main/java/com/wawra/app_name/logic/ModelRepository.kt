package com.wawra.app_name.logic

import com.wawra.app_name.database.daos.ModelDao
import com.wawra.app_name.database.entities.Model
import com.wawra.app_name.network.ApiInterface
import javax.inject.Inject

class ModelRepository @Inject constructor(
    private val modelDao: ModelDao,
    private val api: ApiInterface
) {

    fun getModelsFromDb() = modelDao.getAll()

    fun getModelsFromApi() = api.getModels()
        .map { response -> response.map { Model(it.id) } }

}