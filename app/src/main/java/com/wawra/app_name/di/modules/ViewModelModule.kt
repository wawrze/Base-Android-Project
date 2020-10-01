package com.wawra.app_name.di.modules

import androidx.lifecycle.ViewModel
import com.wawra.app_name.di.scopes.ViewModelKey
import com.wawra.app_name.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

}