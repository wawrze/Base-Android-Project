package com.wawra.app_name.di.modules

import com.wawra.app_name.database.daos.ModelDao
import com.wawra.app_name.di.scopes.AppScoped
import com.wawra.app_name.logic.ModelRepository
import com.wawra.app_name.network.ApiInterface
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @AppScoped
    @Provides
    fun provideModelRepository(
        modelDao: ModelDao,
        api: ApiInterface
    ): ModelRepository = ModelRepository(modelDao, api)

}