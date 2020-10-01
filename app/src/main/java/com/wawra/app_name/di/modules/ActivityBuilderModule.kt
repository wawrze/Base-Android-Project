package com.wawra.app_name.di.modules

import com.wawra.app_name.di.scopes.ActivityScoped
import com.wawra.app_name.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity?

}