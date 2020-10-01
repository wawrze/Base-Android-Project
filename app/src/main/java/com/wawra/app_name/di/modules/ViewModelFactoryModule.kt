package com.wawra.app_name.di.modules

import androidx.lifecycle.ViewModelProvider
import com.wawra.app_name.base.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

}