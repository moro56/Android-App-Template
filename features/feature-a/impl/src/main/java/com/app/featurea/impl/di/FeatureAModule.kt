package com.app.featurea.impl.di

import com.app.featurea.api.ModuleAApi
import com.app.featurea.impl.ModuleA
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object FeatureAModule {

    @Provides
    fun providesModuleAFeatureApi(): ModuleAApi = ModuleA()
}