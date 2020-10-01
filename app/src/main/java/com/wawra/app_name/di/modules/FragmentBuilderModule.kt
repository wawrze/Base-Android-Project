package com.wawra.app_name.di.modules

import com.wawra.app_name.di.scopes.FragmentScoped
import com.wawra.app_name.presentation.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeMainFragment(): MainFragment?

}